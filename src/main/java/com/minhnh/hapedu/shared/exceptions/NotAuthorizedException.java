package com.minhnh.hapedu.shared.exceptions;

public class NotAuthorizedException extends RuntimeException {
    public NotAuthorizedException(String errorMsg) {
        super(errorMsg);
    }
}
