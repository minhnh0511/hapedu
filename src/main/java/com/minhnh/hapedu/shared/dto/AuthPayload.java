package com.minhnh.hapedu.shared.dto;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthPayload {
    private Integer id;
    private String name;
    private String username;
    private String email;
    private Boolean isSuperuser;
    private String role;
}
