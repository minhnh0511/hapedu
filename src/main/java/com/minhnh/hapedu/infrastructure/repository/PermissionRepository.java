package com.minhnh.hapedu.infrastructure.repository;

import com.minhnh.hapedu.infrastructure.entity.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PermissionRepository extends JpaRepository<PermissionEntity, Integer> {
    @Query(value = """
    select p.* 
    from permissions p
    join role_permissions rp on p.id = rp.permission_id 
    where rp.role_id = :roleId
    """, nativeQuery = true)
    List<PermissionEntity> findAllByRoleId(Integer roleId);
}