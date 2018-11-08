package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * MessageRequestDTO
 */


public class MessageRequestDTO   {
  private String accountNo = null;

  private Integer massageType = null;

  private Integer templateCode = null;

  public MessageRequestDTO accountNo(String accountNo) {
    this.accountNo = accountNo;
    return this;
  }

   /**
   * Get accountNo
   * @return accountNo
  **/
  @ApiModelProperty(value = "")
  public String getAccountNo() {
    return accountNo;
  }

  public void setAccountNo(String accountNo) {
    this.accountNo = accountNo;
  }

  public MessageRequestDTO massageType(Integer massageType) {
    this.massageType = massageType;
    return this;
  }

   /**
   * Get massageType
   * @return massageType
  **/
  @ApiModelProperty(value = "")
  public Integer getMassageType() {
    return massageType;
  }

  public void setMassageType(Integer massageType) {
    this.massageType = massageType;
  }

  public MessageRequestDTO templateCode(Integer templateCode) {
    this.templateCode = templateCode;
    return this;
  }

   /**
   * Get templateCode
   * @return templateCode
  **/
  @ApiModelProperty(value = "")
  public Integer getTemplateCode() {
    return templateCode;
  }

  public void setTemplateCode(Integer templateCode) {
    this.templateCode = templateCode;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MessageRequestDTO messageRequestDTO = (MessageRequestDTO) o;
    return Objects.equals(this.accountNo, messageRequestDTO.accountNo) &&
        Objects.equals(this.massageType, messageRequestDTO.massageType) &&
        Objects.equals(this.templateCode, messageRequestDTO.templateCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountNo, massageType, templateCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MessageRequestDTO {\n");
    
    sb.append("    accountNo: ").append(toIndentedString(accountNo)).append("\n");
    sb.append("    massageType: ").append(toIndentedString(massageType)).append("\n");
    sb.append("    templateCode: ").append(toIndentedString(templateCode)).append("\n");
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

