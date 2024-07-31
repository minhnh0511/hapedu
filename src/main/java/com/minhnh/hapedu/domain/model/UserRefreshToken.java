package com.minhnh.hapedu.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRefreshToken {
    private Integer id;

    private Integer userId;

    private String refreshToken;

    private Boolean invoke;
}
