package com.upin.domain.role;

import com.upin.model.BaseEntity;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @Created by Leslie on 2018/7/27.
 */
@Entity
@Table(indexes = {@Index(columnList = "roleName"), @Index(columnList = "status")})
public class Role extends BaseEntity {
    @Column(nullable = false, unique = true, length = 100)
    private String roleName;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    @NotFound(action = NotFoundAction.IGNORE)
    private Role parent;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id")
    private Set<Role> childrens = new HashSet<>();
    private String description;
    @Column(length = 50)
    private String status;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Role getParent() {
        return parent;
    }

    public void setParent(Role parent) {
        this.parent = parent;
    }

    public Set<Role> getChildrens() {
        return childrens;
    }

    public void setChildrens(Set<Role> childrens) {
        this.childrens = childrens;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
