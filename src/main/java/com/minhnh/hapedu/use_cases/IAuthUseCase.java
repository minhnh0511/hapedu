package com.minhnh.hapedu.use_cases;

import com.minhnh.hapedu.application.request.LoginRequest;
import com.minhnh.hapedu.application.response.LoginResponse;

public interface IAuthUseCase {
    LoginResponse login(LoginRequest request) throws IllegalAccessException;
}
