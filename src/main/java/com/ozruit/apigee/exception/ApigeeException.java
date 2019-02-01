package com.ozruit.apigee.exception;

public class ApigeeException extends RuntimeException {
    private int statusCodeValue;

    public ApigeeException(String message, int statusCodeValue) {
        super(message);
        this.statusCodeValue = statusCodeValue;
    }

    public int getStatusCodeValue() {
        return statusCodeValue;
    }
}
