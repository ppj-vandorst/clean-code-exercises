package com.novi.easyboat.exceptions;

public class InvalidBookingException extends RuntimeException {
    public InvalidBookingException(String msg) {
        super(msg);
    }
}
