package com.minhnh.hapedu.domain.adapter;

import com.minhnh.hapedu.domain.model.Role;

public interface RoleAdapter {
    Role findById(Integer id);
    Role findByCode(String code);
}
