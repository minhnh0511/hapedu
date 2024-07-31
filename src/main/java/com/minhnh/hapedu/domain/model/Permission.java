package com.minhnh.hapedu.domain.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Permission {
    private Integer id;

    private String name;

    private String description;

    private String code;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;
}
