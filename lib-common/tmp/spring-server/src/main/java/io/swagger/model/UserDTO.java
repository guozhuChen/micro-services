package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.RoleDTO;
import io.swagger.model.UserDetailDTO;
import java.util.ArrayList;
import java.util.List;




/**
 * UserDTO
 */


public class UserDTO   {
  private String id = null;

  private String createdDate = null;

  private String lastModifiedDate = null;

  private String loginName = null;

  private String password = null;

  private String userTypeId = null;

  private Integer rank = null;

  private String status = null;

  private String lastLoginDate = null;

  private UserDetailDTO userDetail = null;

  private List<RoleDTO> roles = new ArrayList<RoleDTO>();

  public UserDTO id(String id) {
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

  public UserDTO createdDate(String createdDate) {
    this.createdDate = createdDate;
    return this;
  }

   /**
   * Get createdDate
   * @return createdDate
  **/
  @ApiModelProperty(value = "")
  public String getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(String createdDate) {
    this.createdDate = createdDate;
  }

  public UserDTO lastModifiedDate(String lastModifiedDate) {
    this.lastModifiedDate = lastModifiedDate;
    return this;
  }

   /**
   * Get lastModifiedDate
   * @return lastModifiedDate
  **/
  @ApiModelProperty(value = "")
  public String getLastModifiedDate() {
    return lastModifiedDate;
  }

  public void setLastModifiedDate(String lastModifiedDate) {
    this.lastModifiedDate = lastModifiedDate;
  }

  public UserDTO loginName(String loginName) {
    this.loginName = loginName;
    return this;
  }

   /**
   * Get loginName
   * @return loginName
  **/
  @ApiModelProperty(value = "")
  public String getLoginName() {
    return loginName;
  }

  public void setLoginName(String loginName) {
    this.loginName = loginName;
  }

  public UserDTO password(String password) {
    this.password = password;
    return this;
  }

   /**
   * Get password
   * @return password
  **/
  @ApiModelProperty(value = "")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public UserDTO userTypeId(String userTypeId) {
    this.userTypeId = userTypeId;
    return this;
  }

   /**
   * Get userTypeId
   * @return userTypeId
  **/
  @ApiModelProperty(value = "")
  public String getUserTypeId() {
    return userTypeId;
  }

  public void setUserTypeId(String userTypeId) {
    this.userTypeId = userTypeId;
  }

  public UserDTO rank(Integer rank) {
    this.rank = rank;
    return this;
  }

   /**
   * Get rank
   * @return rank
  **/
  @ApiModelProperty(value = "")
  public Integer getRank() {
    return rank;
  }

  public void setRank(Integer rank) {
    this.rank = rank;
  }

  public UserDTO status(String status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public UserDTO lastLoginDate(String lastLoginDate) {
    this.lastLoginDate = lastLoginDate;
    return this;
  }

   /**
   * Get lastLoginDate
   * @return lastLoginDate
  **/
  @ApiModelProperty(value = "")
  public String getLastLoginDate() {
    return lastLoginDate;
  }

  public void setLastLoginDate(String lastLoginDate) {
    this.lastLoginDate = lastLoginDate;
  }

  public UserDTO userDetail(UserDetailDTO userDetail) {
    this.userDetail = userDetail;
    return this;
  }

   /**
   * Get userDetail
   * @return userDetail
  **/
  @ApiModelProperty(value = "")
  public UserDetailDTO getUserDetail() {
    return userDetail;
  }

  public void setUserDetail(UserDetailDTO userDetail) {
    this.userDetail = userDetail;
  }

  public UserDTO roles(List<RoleDTO> roles) {
    this.roles = roles;
    return this;
  }

  public UserDTO addRolesItem(RoleDTO rolesItem) {
    this.roles.add(rolesItem);
    return this;
  }

   /**
   * Get roles
   * @return roles
  **/
  @ApiModelProperty(value = "")
  public List<RoleDTO> getRoles() {
    return roles;
  }

  public void setRoles(List<RoleDTO> roles) {
    this.roles = roles;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserDTO userDTO = (UserDTO) o;
    return Objects.equals(this.id, userDTO.id) &&
        Objects.equals(this.createdDate, userDTO.createdDate) &&
        Objects.equals(this.lastModifiedDate, userDTO.lastModifiedDate) &&
        Objects.equals(this.loginName, userDTO.loginName) &&
        Objects.equals(this.password, userDTO.password) &&
        Objects.equals(this.userTypeId, userDTO.userTypeId) &&
        Objects.equals(this.rank, userDTO.rank) &&
        Objects.equals(this.status, userDTO.status) &&
        Objects.equals(this.lastLoginDate, userDTO.lastLoginDate) &&
        Objects.equals(this.userDetail, userDTO.userDetail) &&
        Objects.equals(this.roles, userDTO.roles);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, createdDate, lastModifiedDate, loginName, password, userTypeId, rank, status, lastLoginDate, userDetail, roles);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserDTO {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    createdDate: ").append(toIndentedString(createdDate)).append("\n");
    sb.append("    lastModifiedDate: ").append(toIndentedString(lastModifiedDate)).append("\n");
    sb.append("    loginName: ").append(toIndentedString(loginName)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    userTypeId: ").append(toIndentedString(userTypeId)).append("\n");
    sb.append("    rank: ").append(toIndentedString(rank)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    lastLoginDate: ").append(toIndentedString(lastLoginDate)).append("\n");
    sb.append("    userDetail: ").append(toIndentedString(userDetail)).append("\n");
    sb.append("    roles: ").append(toIndentedString(roles)).append("\n");
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

