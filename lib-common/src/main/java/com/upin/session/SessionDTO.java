package com.upin.session;
import java.io.Serializable;

import java.util.Objects;


import java.util.ArrayList;
import java.util.List;




/**
 * SessionDTO
 */


public class SessionDTO implements Serializable{
  private String token = null;

  private String userId = null;

  private List<String> roles = new ArrayList<String>();

  public SessionDTO token(String token) {
    this.token = token;
    return this;
  }

   /**
   * Get token
   * @return token
  **/
  
  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public SessionDTO userId(String userId) {
    this.userId = userId;
    return this;
  }

   /**
   * Get userId
   * @return userId
  **/
  
  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public SessionDTO roles(List<String> roles) {
    this.roles = roles;
    return this;
  }

  public SessionDTO addRolesItem(String rolesItem) {
    this.roles.add(rolesItem);
    return this;
  }

   /**
   * Get roles
   * @return roles
  **/
  
  public List<String> getRoles() {
    return roles;
  }

  public void setRoles(List<String> roles) {
    this.roles = roles;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SessionDTO sessionDTO = (SessionDTO) o;
    return Objects.equals(this.token, sessionDTO.token) &&
        Objects.equals(this.userId, sessionDTO.userId) &&
        Objects.equals(this.roles, sessionDTO.roles);
  }

  @Override
  public int hashCode() {
    return Objects.hash(token, userId, roles);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SessionDTO implements Serializable{\n");
    
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    roles: ").append(toIndentedString(roles)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

