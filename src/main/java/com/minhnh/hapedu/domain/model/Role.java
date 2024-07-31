package com.minhnh.hapedu.domain.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Role {
    private Integer id;

    private String name;

    private String description;

    private String code;

    private List<Permission> permissions;

    private LocalDateTime createdDate;
}
