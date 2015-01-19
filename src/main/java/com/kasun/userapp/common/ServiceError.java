package com.kasun.userapp.common;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ServiceError implements Serializable {
    private String code;
    private String message;
    private Throwable trace;

    public ServiceError(String code, String message, Throwable trace) {
        this.code = code;
        this.message = message;
        this.trace = trace;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public Throwable getTrace() {
        return this.trace;
    }
}

