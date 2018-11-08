package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * UserDetailDTO
 */


public class UserDetailDTO   {
  private String id = null;

  private String name = null;

  private String gender = null;

  private String birthDay = null;

  private Integer cardType = null;

  private String cardId = null;

  private String phone = null;

  private String email = null;

  private String areaId = null;

  private String address = null;

  private String heardUrl = null;

  public UserDetailDTO id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public UserDetailDTO name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public UserDetailDTO gender(String gender) {
    this.gender = gender;
    return this;
  }

   /**
   * Get gender
   * @return gender
  **/
  @ApiModelProperty(value = "")
  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public UserDetailDTO birthDay(String birthDay) {
    this.birthDay = birthDay;
    return this;
  }

   /**
   * Get birthDay
   * @return birthDay
  **/
  @ApiModelProperty(value = "")
  public String getBirthDay() {
    return birthDay;
  }

  public void setBirthDay(String birthDay) {
    this.birthDay = birthDay;
  }

  public UserDetailDTO cardType(Integer cardType) {
    this.cardType = cardType;
    return this;
  }

   /**
   * Get cardType
   * @return cardType
  **/
  @ApiModelProperty(value = "")
  public Integer getCardType() {
    return cardType;
  }

  public void setCardType(Integer cardType) {
    this.cardType = cardType;
  }

  public UserDetailDTO cardId(String cardId) {
    this.cardId = cardId;
    return this;
  }

   /**
   * Get cardId
   * @return cardId
  **/
  @ApiModelProperty(value = "")
  public String getCardId() {
    return cardId;
  }

  public void setCardId(String cardId) {
    this.cardId = cardId;
  }

  public UserDetailDTO phone(String phone) {
    this.phone = phone;
    return this;
  }

   /**
   * Get phone
   * @return phone
  **/
  @ApiModelProperty(value = "")
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public UserDetailDTO email(String email) {
    this.email = email;
    return this;
  }

   /**
   * Get email
   * @return email
  **/
  @ApiModelProperty(value = "")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public UserDetailDTO areaId(String areaId) {
    this.areaId = areaId;
    return this;
  }

   /**
   * Get areaId
   * @return areaId
  **/
  @ApiModelProperty(value = "")
  public String getAreaId() {
    return areaId;
  }

  public void setAreaId(String areaId) {
    this.areaId = areaId;
  }

  public UserDetailDTO address(String address) {
    this.address = address;
    return this;
  }

   /**
   * Get address
   * @return address
  **/
  @ApiModelProperty(value = "")
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public UserDetailDTO heardUrl(String heardUrl) {
    this.heardUrl = heardUrl;
    return this;
  }

   /**
   * Get heardUrl
   * @return heardUrl
  **/
  @ApiModelProperty(value = "")
  public String getHeardUrl() {
    return heardUrl;
  }

  public void setHeardUrl(String heardUrl) {
    this.heardUrl = heardUrl;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserDetailDTO userDetailDTO = (UserDetailDTO) o;
    return Objects.equals(this.id, userDetailDTO.id) &&
        Objects.equals(this.name, userDetailDTO.name) &&
        Objects.equals(this.gender, userDetailDTO.gender) &&
        Objects.equals(this.birthDay, userDetailDTO.birthDay) &&
        Objects.equals(this.cardType, userDetailDTO.cardType) &&
        Objects.equals(this.cardId, userDetailDTO.cardId) &&
        Objects.equals(this.phone, userDetailDTO.phone) &&
        Objects.equals(this.email, userDetailDTO.email) &&
        Objects.equals(this.areaId, userDetailDTO.areaId) &&
        Objects.equals(this.address, userDetailDTO.address) &&
        Objects.equals(this.heardUrl, userDetailDTO.heardUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, gender, birthDay, cardType, cardId, phone, email, areaId, address, heardUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserDetailDTO {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    birthDay: ").append(toIndentedString(birthDay)).append("\n");
    sb.append("    cardType: ").append(toIndentedString(cardType)).append("\n");
    sb.append("    cardId: ").append(toIndentedString(cardId)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    areaId: ").append(toIndentedString(areaId)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    heardUrl: ").append(toIndentedString(heardUrl)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

