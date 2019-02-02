package com.ozruit.model;

public class ResponseStatus {
    private String code;
    private String errorMessage;

    public ResponseStatus(String code, String message) {
        this.code = code;
        this.errorMessage = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
