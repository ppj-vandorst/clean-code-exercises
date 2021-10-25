package com.novi.easyboat.exceptions;

public class BadRequestException extends RuntimeException {
    public BadRequestException() {
    }

    public BadRequestException(String msg) {
        super(msg);
    }
}
