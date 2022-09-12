package com.softuni.CarsBg.entity;

import com.softuni.CarsBg.entity.enums.UserRoleEnum;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRoleEnum userRoleEnum;

    public UserRole() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserRoleEnum getUserRoleEnum() {
        return userRoleEnum;
    }

    public void setUserRoleEnum(UserRoleEnum userRoleEnum) {
        this.userRoleEnum = userRoleEnum;
    }
}
