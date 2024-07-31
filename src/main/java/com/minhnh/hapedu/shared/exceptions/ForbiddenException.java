package com.minhnh.hapedu.shared.exceptions;

public class ForbiddenException extends RuntimeException {
    public ForbiddenException(String errorMsg) {
        super(errorMsg);
    }
}
