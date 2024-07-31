package com.minhnh.hapedu.infrastructure.repository;

import com.minhnh.hapedu.infrastructure.entity.UserRefreshTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRefreshTokenRepository extends JpaRepository<UserRefreshTokenEntity, Integer> {
    List<UserRefreshTokenEntity> findAllByUserIdAndInvoke(Long userId, Boolean invoke);
}