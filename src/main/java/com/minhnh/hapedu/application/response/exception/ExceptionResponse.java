package com.minhnh.hapedu.application.response.exception;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ExceptionResponse {
    private String message;
    private boolean success;

    public boolean getSuccess() {
        return success;
    }
}
