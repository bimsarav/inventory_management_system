package com.kasun.userapp.inventory.dto;

import com.kasun.userapp.common.Tanent;

/**
 * @author Kasun Kariyawasam
 *
 * Jan 3, 2015
 */
@SuppressWarnings("serial")
public class InventorySearchCriteria extends Tanent{
	
	
	public InventorySearchCriteria(String tenantCode) {
		super(tenantCode);
	}
	private String inventoryId;
	private String inventoryName;
	private String hospital;
	
	public String getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(String inventoryId) {
		this.inventoryId = inventoryId;
	}
	public String getInventoryName() {
		return inventoryName;
	}
	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}
	public String getHospital() {
		return hospital;
	}
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
	
	
	
}
