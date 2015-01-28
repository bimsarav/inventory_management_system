package com.kasun.userapp.inventory.model;

import java.util.Date;

public class Inventory {

	private String inventoryId;
	private String name;
	private int availableAmount;
	private int soldAmount;
	@SuppressWarnings("unused")
	private int restAmount;
	private int pricePerUnit;
	private String location;
	private String description;
	private Date createdDate;

	public void setRestAmount() {
		this.restAmount = this.availableAmount - this.soldAmount;
	}
	
	public String getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(String inventoryId) {
		this.inventoryId = inventoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAvailableAmount() {
		return availableAmount;
	}

	public void setAvailableAmount(int availableAmount) {
		this.availableAmount = availableAmount;
	}

	public int getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(int pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getSoldAmount() {
		return soldAmount;
	}

	public void setSoldAmount(int soldAmount) {
		this.soldAmount = soldAmount;
	}

	public int getRestAmount() {
		return (this.availableAmount-this.soldAmount);
	}	
}
