package com.upin.domain.user;

import com.upin.domain.role.Role;
import com.upin.model.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Created by Leslie on 2018/7/25.
 */
@Entity
@Table(indexes = {@Index(columnList = "userTypeId"), @Index(columnList = "status")})
public class User extends BaseEntity {
    @Column(nullable = false, unique = true, length = 100)
    private String loginName;
    @Column(nullable = false, length = 100)
    private String password;
    private String userTypeId;
    @Column(columnDefinition = "tinyint default 1")
    private Integer rank;
    @Column(length = 50)
    private String status;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLoginDate;

    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private UserDetail userDetail;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles = new ArrayList<>();

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(String userTypeId) {
        this.userTypeId = userTypeId;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
