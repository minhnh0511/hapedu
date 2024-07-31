package com.minhnh.hapedu.shared.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String errorMsg) {
        super(errorMsg);
    }
}
