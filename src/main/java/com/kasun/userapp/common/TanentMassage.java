package com.kasun.userapp.common;

//import com.isa.commons.api.tenant.dto.Tenant;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TanentMassage implements Serializable{

	    private Tanent tenant;

	    public TanentMassage() {
	    }

	    public Tanent getTenant() {
	        return this.tenant;
	    }

	    public void setTenant(Tanent tenant) {
	        this.tenant = tenant;
	    }
}

