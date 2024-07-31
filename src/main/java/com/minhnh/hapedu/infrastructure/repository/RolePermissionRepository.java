package com.minhnh.hapedu.infrastructure.repository;

import com.minhnh.hapedu.infrastructure.entity.RolePermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolePermissionRepository extends JpaRepository<RolePermissionEntity, Integer> {
}