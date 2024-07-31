package com.minhnh.hapedu.infrastructure.configuration.init;

import com.minhnh.hapedu.common.enums.RoleEnum;
import com.minhnh.hapedu.infrastructure.entity.RoleEntity;
import com.minhnh.hapedu.infrastructure.repository.RoleRepository;
import com.minhnh.hapedu.shared.utils.ListUtils;
import com.minhnh.hapedu.shared.utils.ModelTransformUtils;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class RoleInitializationConfig {
    private final RoleRepository roleRepository;
    private final List<String> initCodes = RoleEnum.getInitCodes();

    @PostConstruct
    public void initRole() {
        List<RoleEntity> roleEntities = roleRepository.findAll();
        List<String> existingCodes = ModelTransformUtils.getAttribute(roleEntities, RoleEntity::getCode);
        List<String> missingCodes = ListUtils.diff(initCodes, existingCodes);
        List<RoleEntity> toAddRoles = new ArrayList<>();
        for (String code : missingCodes) {
            toAddRoles.add(RoleEntity.builder()
                    .code(code)
                    .name(Objects.requireNonNull(RoleEnum.getByCode(code)).getName())
                    .description(Objects.requireNonNull(RoleEnum.getByCode(code)).getDescription())
                    .build());
        }
        roleRepository.saveAll(toAddRoles);
    }
}
