package com.kasun.userapp.inventory.dto;

import java.io.Serializable;

/**
 * @author Kasun Kariyawasam
 *
 * Dec 21, 2014
 */

@SuppressWarnings("serial")
public class Tenant implements Serializable{
	
	private String tenantId;

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
}