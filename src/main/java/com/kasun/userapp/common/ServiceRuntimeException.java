package com.kasun.userapp.common;

@SuppressWarnings("serial")
public class ServiceRuntimeException extends RuntimeException {
    private String code;

    public ServiceRuntimeException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public ServiceRuntimeException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}
