package com.minhnh.hapedu.domain.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    private Integer id;

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private LocalDateTime registeredDate;

    private String email;

    private String phone;

    private Boolean isActive;

    private Integer roleId;

    private Role role;

    private Boolean isSuperuser;
}
