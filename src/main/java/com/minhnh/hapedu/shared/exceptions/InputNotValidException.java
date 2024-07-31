package com.minhnh.hapedu.shared.exceptions;

public class InputNotValidException extends RuntimeException{
    public InputNotValidException(String errorMsg){
        super(errorMsg);
    }
}
