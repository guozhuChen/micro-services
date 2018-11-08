if [ -d "tmp/" ]; then
  rm -rf tmp
fi

mkdir tmp

java -jar tool/swagger-codegen-cli-2.2.1.jar  generate -i api/api.yaml -l spring -o tmp/spring-server/


#update package name 
find tmp/spring-server/src/main/java/io/swagger/model/ -name "*.java" |xargs sed -i 's/io.swagger.model/com.upin.dtos/g'

#add serializable import
find tmp/spring-server/src/main/java/io/swagger/model/ -name "*.java" |xargs sed -i '/^package/a\import\ java\.io\.Serializable;'

#add change to serialiable 
find tmp/spring-server/src/main/java/io/swagger/model/ -name "*.java" |xargs sed -i 's/DTO\ *{/DTO\ implements\ Serializable{/g'

#delete the comments of generated date
find tmp/spring-server/src/main/java/io/swagger/model/ -name "*.java" |xargs sed -i 's/^@javax.annotation.Generated.*$//g'
find tmp/spring-server/src/main/java/io/swagger/model/ -name "*.java" |xargs sed -i 's/^@ApiModel.*$//g'
find tmp/spring-server/src/main/java/io/swagger/model/ -name "*.java" |xargs sed -i 's/@ApiModelProperty.*$//g'
find tmp/spring-server/src/main/java/io/swagger/model/ -name "*.java" |xargs sed -i 's/^import\ io.swagger.annotations.*$//g'
find tmp/spring-server/src/main/java/io/swagger/model/ -name "*.java" |xargs sed -i 's/^import\ javax.validation.constraints.*$//g'

echo "start replace"
#replace model to dto common
rm -rf src/main/java/com/upin/dtos
mkdir -p src/main/java/com/upin/dtos 
cp -R tmp/spring-server/src/main/java/io/swagger/model/* src/main/java/com/upin/dtos

echo "done replace"

echo "start generate stub" 
rm -rf tmp
mkdir tmp

java -jar tool/swagger-codegen-cli-2.2.1.jar  generate -i api/api.yaml -l spring -o tmp/spring-server/

find tmp/spring-server/src/main/java/io/swagger/ -name "*.java" |xargs sed -i 's/^@javax.annotation.Generated.*$//g'

