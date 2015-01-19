package com.kasun.userapp.common;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Tanent implements Serializable {
	
	    private String code;
	    private String name;

	    public Tanent(String tenantCode) {
	        this.code = tenantCode;
	    }

	    public String getCode() {
	        return this.code;
	    }

	    public void setCode(String code) {
	        this.code = code;
	    }

	    public String getName() {
	        return this.name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }
}

