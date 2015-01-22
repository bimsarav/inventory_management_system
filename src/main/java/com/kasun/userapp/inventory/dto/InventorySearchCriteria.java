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
	private String hospital;
	private String price;
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

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
}
