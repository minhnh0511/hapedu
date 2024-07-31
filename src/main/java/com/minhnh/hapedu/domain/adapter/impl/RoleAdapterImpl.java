package com.minhnh.hapedu.domain.adapter.impl;

import com.minhnh.hapedu.domain.adapter.RoleAdapter;
import com.minhnh.hapedu.domain.model.Permission;
import com.minhnh.hapedu.domain.model.Role;
import com.minhnh.hapedu.infrastructure.entity.RoleEntity;
import com.minhnh.hapedu.infrastructure.repository.PermissionRepository;
import com.minhnh.hapedu.infrastructure.repository.RoleRepository;
import com.minhnh.hapedu.shared.annotations.Adapter;
import com.minhnh.hapedu.shared.utils.ModelMapperUtils;
import lombok.RequiredArgsConstructor;

import java.util.Objects;
import java.util.Optional;

@Adapter
@RequiredArgsConstructor
public class RoleAdapterImpl implements RoleAdapter {
    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;
    @Override
    public Role findById(Integer id) {
        Optional<RoleEntity> roleEntityOptional = roleRepository.findById(id);
        Role role = roleEntityOptional
                .map(roleEntity -> ModelMapperUtils.mapper(roleEntity, Role.class))
                .orElse(null);
        enrichPermissions(role);
        return role;
    }

    @Override
    public Role findByCode(String code) {
        Optional<RoleEntity> roleEntityOptional = roleRepository.findByCode(code);
        Role role = roleEntityOptional
                .map(roleEntity -> ModelMapperUtils.mapper(roleEntity, Role.class))
                .orElse(null);
        enrichPermissions(role);
        return role;
    }

    private void enrichPermissions(Role role) {
        if(Objects.nonNull(role))
            role.setPermissions(ModelMapperUtils.mapList(permissionRepository.findAllByRoleId(role.getId()),
                    Permission.class));
    }
}
