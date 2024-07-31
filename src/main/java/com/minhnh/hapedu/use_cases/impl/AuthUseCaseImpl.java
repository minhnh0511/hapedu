package com.minhnh.hapedu.use_cases.impl;

import com.minhnh.hapedu.application.request.LoginRequest;
import com.minhnh.hapedu.application.response.LoginResponse;
import com.minhnh.hapedu.common.enums.RoleEnum;
import com.minhnh.hapedu.domain.adapter.RoleAdapter;
import com.minhnh.hapedu.domain.adapter.UserAdapter;
import com.minhnh.hapedu.domain.adapter.UserRefreshTokenAdapter;
import com.minhnh.hapedu.domain.model.User;
import com.minhnh.hapedu.domain.service.UserService;
import com.minhnh.hapedu.infrastructure.configuration.security.JwtTokenProvider;
import com.minhnh.hapedu.shared.dto.AuthPayload;
import com.minhnh.hapedu.shared.exceptions.NotAuthorizedException;
import com.minhnh.hapedu.shared.utils.ObjectUtils;
import com.minhnh.hapedu.use_cases.IAuthUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Objects;

@Component
@RequiredArgsConstructor
@Log4j2
public class AuthUseCaseImpl implements IAuthUseCase {
    private final UserAdapter userAdapter;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final UserRefreshTokenAdapter userRefreshTokenAdapter;
    private final RoleAdapter roleAdapter;
    private final UserService userService;
    private final MessageSource messageSource;

    @Value("${hapedu.security.authentication.jwt.token-validity-in-seconds}")
    private int jwtExpiration;

    @Override
    @Transactional
    public LoginResponse login(LoginRequest request) throws IllegalAccessException {
        User user = userAdapter.findByUsername(request.getUsername());
        if(Objects.isNull(user)) {
            throw new NotAuthorizedException(messageSource
                    .getMessage("username_not_found", null, Locale.getDefault()));
        }
        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new NotAuthorizedException(messageSource
                    .getMessage("incorrect_password_or_username", null, Locale.getDefault()));
        }
        AuthPayload authPayload = generateAuthPayload(user);

        String accessToken = jwtTokenProvider
                .generateAccessToken(user, ObjectUtils.convertUsingReflection(authPayload));
        String refreshToken = jwtTokenProvider
                .generateRefreshToken(user, ObjectUtils.convertUsingReflection(authPayload));

        return LoginResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .expiresIn(LocalDateTime.now().plusSeconds(jwtExpiration))
                .userInfo(user)
                .build();
    }

    private AuthPayload generateAuthPayload(User user) {
        return AuthPayload.builder()
                .id(user.getId())
                .name((user.getFirstName() + " " + user.getLastName()).trim())
                .username(user.getUsername())
                .email(user.getEmail())
                .isSuperuser(user.getIsSuperuser())
                .role(user.getRole().getCode())
                .build();
    }
}
