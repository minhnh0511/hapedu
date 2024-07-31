package com.minhnh.hapedu.domain.adapter.impl;

import com.minhnh.hapedu.domain.adapter.RoleAdapter;
import com.minhnh.hapedu.domain.adapter.UserAdapter;
import com.minhnh.hapedu.domain.model.User;
import com.minhnh.hapedu.infrastructure.entity.UserEntity;
import com.minhnh.hapedu.infrastructure.repository.UserRepository;
import com.minhnh.hapedu.shared.annotations.Adapter;
import com.minhnh.hapedu.shared.utils.ModelMapperUtils;
import lombok.RequiredArgsConstructor;

import java.util.Objects;
import java.util.Optional;

@Adapter
@RequiredArgsConstructor
public class UserAdapterImpl implements UserAdapter {
    private final UserRepository userRepository;
    private final RoleAdapter roleAdapter;
    @Override
    public User findByUsername(String username) {
        Optional<UserEntity> userOptional = userRepository.findByUsername(username);
        User user = userOptional
                .map(userEntity -> ModelMapperUtils.mapper(userEntity, User.class))
                .orElse(null);
        if(Objects.nonNull(user))
            user.setRole(roleAdapter.findById(user.getRoleId()));
        return user;
    }
}
