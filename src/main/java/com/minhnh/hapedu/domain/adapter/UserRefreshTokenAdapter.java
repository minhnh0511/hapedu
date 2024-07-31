package com.minhnh.hapedu.domain.adapter;

import com.minhnh.hapedu.domain.model.UserRefreshToken;

import java.util.List;

public interface UserRefreshTokenAdapter {
    List<UserRefreshToken> findAllByUserIdAndInvoke(Long userId, Boolean invoke);
    UserRefreshToken save(UserRefreshToken userRefreshToken);
}
