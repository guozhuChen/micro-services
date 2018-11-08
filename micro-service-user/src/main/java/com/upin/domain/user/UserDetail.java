package com.upin.domain.user;

import com.upin.model.BaseId;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

/**
 * @Created by Leslie on 2018/7/25.
 */
@Entity
public class UserDetail extends BaseId {
    @Column(length = 128)
    private String name;
    @Column(length = 10)
    private String gender;
    private Date birthDay;
    private Integer cardType;
    @Column(length = 128, unique = true)
    private String cardId;
    @Column(length = 11)
    private String phone;
    @Column(length = 128)
    private String email;
    private String areaId;
    private String address;
    private String hearUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHearUrl() {
        return hearUrl;
    }

    public void setHearUrl(String hearUrl) {
        this.hearUrl = hearUrl;
    }
}
