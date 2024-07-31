package com.minhnh.hapedu.domain.adapter;

import com.minhnh.hapedu.domain.model.User;

public interface UserAdapter {
    User findByUsername(String username);
}
