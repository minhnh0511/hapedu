package com.minhnh.hapedu.infrastructure.repository;

import com.minhnh.hapedu.infrastructure.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
    Optional<RoleEntity> findByCode(String code);
}