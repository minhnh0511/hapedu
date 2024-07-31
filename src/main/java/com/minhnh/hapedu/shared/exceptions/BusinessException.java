package com.minhnh.hapedu.shared.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BusinessException extends RuntimeException {
    private final HttpStatus httpStatus;
    private final String messageCode;

    public BusinessException(String errorMessage, HttpStatus httpStatus, String messageCode) {
        super(errorMessage);
        this.httpStatus = httpStatus;
        this.messageCode = messageCode;
    }
}
