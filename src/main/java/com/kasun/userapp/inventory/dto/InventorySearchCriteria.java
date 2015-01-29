package com.kasun.userapp.inventory.dto;

import java.io.Serializable;

/**
 * @author Kasun Kariyawasam
 *
 *         Jan 3, 2015
 */
@SuppressWarnings("serial")
public class InventorySearchCriteria implements Serializable {

	private String inventoryId;
	private String inventoryName;
	private String location;
	private String pricePerUnit;
	private String createdDate;

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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(String pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
}
