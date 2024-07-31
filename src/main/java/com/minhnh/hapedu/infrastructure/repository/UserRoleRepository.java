package com.minhnh.hapedu.infrastructure.repository;

import com.minhnh.hapedu.infrastructure.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Integer> {
}