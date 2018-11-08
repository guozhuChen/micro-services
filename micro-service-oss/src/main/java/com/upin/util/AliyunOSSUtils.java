package com.upin.util;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.Bucket;
import com.aliyun.oss.model.ObjectMetadata;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

/**
 * @Created by Leslie on 2018/7/24.
 */
public class AliyunOSSUtils {
    private String endPoint ;
    private String accessKeyId ;
    private String accessKeySecret ;
    private String publicBucketName ;
    private String privateBucketName ;
    private Double expirationHours ;

    public AliyunOSSUtils(String endPoint, String accessKeyId, String accessKeySecret, String publicBucketName, String privateBucketName, Double expirationHours) {
        this.endPoint = endPoint;
        this.accessKeyId = accessKeyId;
        this.accessKeySecret = accessKeySecret;
        this.publicBucketName = publicBucketName;
        this.privateBucketName = privateBucketName;
        this.expirationHours = expirationHours;
    }

    public OSSClient getOSSClient(){
        return new OSSClient(endPoint, accessKeyId, accessKeySecret);
    }

    /**
     *  创建存储空间
     */
    public String createBucketName(String bucketName){
        OSSClient ossClient = getOSSClient();
        //存储空间
        final String bucketNames=bucketName;
        if(!ossClient.doesBucketExist(bucketName)){
            //创建存储空间
            Bucket bucket=ossClient.createBucket(bucketName);
            return bucket.getName();
        }
        return bucketNames;
    }

    /**
     *  删除存储空间
     */
    public void deleteBucket(String bucketName){
        OSSClient ossClient = getOSSClient();
        ossClient.deleteBucket(bucketName);
    }

    /**
     * 上传文件
     */
    public String upload(File file, boolean isPublic) throws Exception {
        String bucketName = isPublic ? publicBucketName : privateBucketName ;
        return uploadInternal(file, bucketName);
    }

    /**
     * 根据key 返回url
     */
    public String getUrl(String key, String bucketName){
        OSSClient ossClient = getOSSClient();
        Date expiration = new Date(System.currentTimeMillis() + (int)(expirationHours * 3600 * 1000));
        URL url = ossClient.generatePresignedUrl(bucketName, key, expiration);
        return String.valueOf(url);
    }

    private String uploadInternal(File file, String bucketName) throws Exception {
        OSSClient ossClient = getOSSClient();
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentEncoding("utf-8");
        metadata.setContentLength(file.length());
        metadata.setContentType(OSSFileType.getContentType(file.getName()));
        ossClient.putObject(bucketName, file.getName(), file, metadata);
        return getUrl(file.getName(), bucketName);
    }

}
