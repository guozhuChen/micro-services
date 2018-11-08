package com.upin.domain.areas;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @Created by Leslie on 2018/10/31.
 */
@Entity
@Table(indexes = {@Index(columnList = "areaName"), @Index(columnList = "pinYin")})
public class Areas {
    @Id
    private Integer id;
    @Column(nullable = false, length = 100)
    private String areaName;
    private String pinYin;
    @Column(length = 50)
    private String shortName;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    @NotFound(action = NotFoundAction.IGNORE)
    private Areas parent;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id")
    private Set<Areas> childrens = new HashSet<>();
    @Column(length = 20)
    private String type;
    private boolean flag;
    private Double lat;
    private Double lng;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getPinYin() {
        return pinYin;
    }

    public void setPinYin(String pinYin) {
        this.pinYin = pinYin;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Areas getParent() {
        return parent;
    }

    public void setParent(Areas parent) {
        this.parent = parent;
    }

    public Set<Areas> getChildrens() {
        return childrens;
    }

    public void setChildrens(Set<Areas> childrens) {
        this.childrens = childrens;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }
}
