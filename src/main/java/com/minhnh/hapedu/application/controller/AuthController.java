package com.minhnh.hapedu.application.controller;

import com.minhnh.hapedu.application.request.LoginRequest;
import com.minhnh.hapedu.application.response.LoginResponse;
import com.minhnh.hapedu.application.response.base.BaseResponse;
import com.minhnh.hapedu.shared.factory.ResponseFactory;
import com.minhnh.hapedu.use_cases.IAuthUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final IAuthUseCase iAuthUseCase;

    @PostMapping("login")
    public ResponseEntity<BaseResponse<LoginResponse>> login(@RequestBody LoginRequest loginRequest)
            throws IllegalAccessException {
        return ResponseFactory.success(iAuthUseCase.login(loginRequest));
    }
}
