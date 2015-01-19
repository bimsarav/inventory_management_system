package com.kasun.userapp.common;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ServiceWarning implements Serializable {
    private String code;
    private String message;

    public ServiceWarning(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
