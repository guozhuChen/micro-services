package com.upin.dtos;
import java.io.Serializable;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;


import com.upin.dtos.RoleDTO;
import java.util.ArrayList;
import java.util.List;




/**
 * RoleDTO
 */


public class RoleDTO implements Serializable{
  private String id = null;

  private String createdDate = null;

  private String lastModifiedDate = null;

  private String roleName = null;

  private RoleDTO parent = null;

  private List<RoleDTO> childrens = new ArrayList<RoleDTO>();

  private String description = null;

  private String status = null;

  public RoleDTO id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public RoleDTO createdDate(String createdDate) {
    this.createdDate = createdDate;
    return this;
  }

   /**
   * Get createdDate
   * @return createdDate
  **/
  
  public String getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(String createdDate) {
    this.createdDate = createdDate;
  }

  public RoleDTO lastModifiedDate(String lastModifiedDate) {
    this.lastModifiedDate = lastModifiedDate;
    return this;
  }

   /**
   * Get lastModifiedDate
   * @return lastModifiedDate
  **/
  
  public String getLastModifiedDate() {
    return lastModifiedDate;
  }

  public void setLastModifiedDate(String lastModifiedDate) {
    this.lastModifiedDate = lastModifiedDate;
  }

  public RoleDTO roleName(String roleName) {
    this.roleName = roleName;
    return this;
  }

   /**
   * Get roleName
   * @return roleName
  **/
  
  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public RoleDTO parent(RoleDTO parent) {
    this.parent = parent;
    return this;
  }

   /**
   * Get parent
   * @return parent
  **/
  
  public RoleDTO getParent() {
    return parent;
  }

  public void setParent(RoleDTO parent) {
    this.parent = parent;
  }

  public RoleDTO childrens(List<RoleDTO> childrens) {
    this.childrens = childrens;
    return this;
  }

  public RoleDTO addChildrensItem(RoleDTO childrensItem) {
    this.childrens.add(childrensItem);
    return this;
  }

   /**
   * Get childrens
   * @return childrens
  **/
  
  public List<RoleDTO> getChildrens() {
    return childrens;
  }

  public void setChildrens(List<RoleDTO> childrens) {
    this.childrens = childrens;
  }

  public RoleDTO description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public RoleDTO status(String status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RoleDTO roleDTO = (RoleDTO) o;
    return Objects.equals(this.id, roleDTO.id) &&
        Objects.equals(this.createdDate, roleDTO.createdDate) &&
        Objects.equals(this.lastModifiedDate, roleDTO.lastModifiedDate) &&
        Objects.equals(this.roleName, roleDTO.roleName) &&
        Objects.equals(this.parent, roleDTO.parent) &&
        Objects.equals(this.childrens, roleDTO.childrens) &&
        Objects.equals(this.description, roleDTO.description) &&
        Objects.equals(this.status, roleDTO.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, createdDate, lastModifiedDate, roleName, parent, childrens, description, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RoleDTO implements Serializable{\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    createdDate: ").append(toIndentedString(createdDate)).append("\n");
    sb.append("    lastModifiedDate: ").append(toIndentedString(lastModifiedDate)).append("\n");
    sb.append("    roleName: ").append(toIndentedString(roleName)).append("\n");
    sb.append("    parent: ").append(toIndentedString(parent)).append("\n");
    sb.append("    childrens: ").append(toIndentedString(childrens)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

