package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.AreasDTO;
import java.util.ArrayList;
import java.util.List;




/**
 * AreasDTO
 */


public class AreasDTO   {
  private Integer id = null;

  private String areaName = null;

  private String pinYin = null;

  private String shortName = null;

  private AreasDTO parent = null;

  private List<AreasDTO> childrens = new ArrayList<AreasDTO>();

  private String type = null;

  private Boolean flag = null;

  private Double lat = null;

  private Double lng = null;

  public AreasDTO id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public AreasDTO areaName(String areaName) {
    this.areaName = areaName;
    return this;
  }

   /**
   * Get areaName
   * @return areaName
  **/
  @ApiModelProperty(value = "")
  public String getAreaName() {
    return areaName;
  }

  public void setAreaName(String areaName) {
    this.areaName = areaName;
  }

  public AreasDTO pinYin(String pinYin) {
    this.pinYin = pinYin;
    return this;
  }

   /**
   * Get pinYin
   * @return pinYin
  **/
  @ApiModelProperty(value = "")
  public String getPinYin() {
    return pinYin;
  }

  public void setPinYin(String pinYin) {
    this.pinYin = pinYin;
  }

  public AreasDTO shortName(String shortName) {
    this.shortName = shortName;
    return this;
  }

   /**
   * Get shortName
   * @return shortName
  **/
  @ApiModelProperty(value = "")
  public String getShortName() {
    return shortName;
  }

  public void setShortName(String shortName) {
    this.shortName = shortName;
  }

  public AreasDTO parent(AreasDTO parent) {
    this.parent = parent;
    return this;
  }

   /**
   * Get parent
   * @return parent
  **/
  @ApiModelProperty(value = "")
  public AreasDTO getParent() {
    return parent;
  }

  public void setParent(AreasDTO parent) {
    this.parent = parent;
  }

  public AreasDTO childrens(List<AreasDTO> childrens) {
    this.childrens = childrens;
    return this;
  }

  public AreasDTO addChildrensItem(AreasDTO childrensItem) {
    this.childrens.add(childrensItem);
    return this;
  }

   /**
   * Get childrens
   * @return childrens
  **/
  @ApiModelProperty(value = "")
  public List<AreasDTO> getChildrens() {
    return childrens;
  }

  public void setChildrens(List<AreasDTO> childrens) {
    this.childrens = childrens;
  }

  public AreasDTO type(String type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(value = "")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public AreasDTO flag(Boolean flag) {
    this.flag = flag;
    return this;
  }

   /**
   * Get flag
   * @return flag
  **/
  @ApiModelProperty(value = "")
  public Boolean getFlag() {
    return flag;
  }

  public void setFlag(Boolean flag) {
    this.flag = flag;
  }

  public AreasDTO lat(Double lat) {
    this.lat = lat;
    return this;
  }

   /**
   * Get lat
   * @return lat
  **/
  @ApiModelProperty(value = "")
  public Double getLat() {
    return lat;
  }

  public void setLat(Double lat) {
    this.lat = lat;
  }

  public AreasDTO lng(Double lng) {
    this.lng = lng;
    return this;
  }

   /**
   * Get lng
   * @return lng
  **/
  @ApiModelProperty(value = "")
  public Double getLng() {
    return lng;
  }

  public void setLng(Double lng) {
    this.lng = lng;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AreasDTO areasDTO = (AreasDTO) o;
    return Objects.equals(this.id, areasDTO.id) &&
        Objects.equals(this.areaName, areasDTO.areaName) &&
        Objects.equals(this.pinYin, areasDTO.pinYin) &&
        Objects.equals(this.shortName, areasDTO.shortName) &&
        Objects.equals(this.parent, areasDTO.parent) &&
        Objects.equals(this.childrens, areasDTO.childrens) &&
        Objects.equals(this.type, areasDTO.type) &&
        Objects.equals(this.flag, areasDTO.flag) &&
        Objects.equals(this.lat, areasDTO.lat) &&
        Objects.equals(this.lng, areasDTO.lng);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, areaName, pinYin, shortName, parent, childrens, type, flag, lat, lng);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AreasDTO {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    areaName: ").append(toIndentedString(areaName)).append("\n");
    sb.append("    pinYin: ").append(toIndentedString(pinYin)).append("\n");
    sb.append("    shortName: ").append(toIndentedString(shortName)).append("\n");
    sb.append("    parent: ").append(toIndentedString(parent)).append("\n");
    sb.append("    childrens: ").append(toIndentedString(childrens)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    flag: ").append(toIndentedString(flag)).append("\n");
    sb.append("    lat: ").append(toIndentedString(lat)).append("\n");
    sb.append("    lng: ").append(toIndentedString(lng)).append("\n");
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

