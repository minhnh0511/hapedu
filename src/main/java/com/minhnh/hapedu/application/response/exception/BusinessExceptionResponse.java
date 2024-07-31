package com.minhnh.hapedu.application.response.exception;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Builder
@Getter
public class BusinessExceptionResponse {
    private String message;
    private boolean success;
    private String messageCode;
    public boolean getSuccess() {
        return success;
    }
}
