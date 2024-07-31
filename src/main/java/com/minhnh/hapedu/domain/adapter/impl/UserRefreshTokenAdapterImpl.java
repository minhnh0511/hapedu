package com.minhnh.hapedu.domain.adapter.impl;

import com.minhnh.hapedu.domain.adapter.UserRefreshTokenAdapter;
import com.minhnh.hapedu.domain.model.UserRefreshToken;
import com.minhnh.hapedu.infrastructure.entity.UserRefreshTokenEntity;
import com.minhnh.hapedu.infrastructure.repository.UserRefreshTokenRepository;
import com.minhnh.hapedu.shared.annotations.Adapter;
import com.minhnh.hapedu.shared.utils.ModelMapperUtils;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Adapter
@RequiredArgsConstructor
public class UserRefreshTokenAdapterImpl implements UserRefreshTokenAdapter {
    private final UserRefreshTokenRepository userRefreshTokenRepository;
    @Override
    public List<UserRefreshToken> findAllByUserIdAndInvoke(Long userId, Boolean invoke) {
        return ModelMapperUtils.mapList(userRefreshTokenRepository.findAllByUserIdAndInvoke(userId, invoke),
                UserRefreshToken.class);
    }

    @Override
    public UserRefreshToken save(UserRefreshToken userRefreshToken) {
        return ModelMapperUtils.mapper(
                userRefreshTokenRepository.save(
                        ModelMapperUtils.mapper(userRefreshToken, UserRefreshTokenEntity.class)),
                UserRefreshToken.class);
    }
}
