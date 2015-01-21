package com.kasun.userapp.inventory.dto;

import java.io.Serializable;

/**
 * @author Kasun Kariyawasam
 *
 * Dec 21, 2014
 */

@SuppressWarnings("serial")
public class InventoryAddParam implements Serializable{

	private String hospital;
	
	private String inventoryId;
	
	private String name;
	
	private String price;
	
	private String userNote;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getHospital() {
		return hospital;
	}
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
	public String getUserNote() {
		return userNote;
	}
	public void setUserNote(String userNote) {
		this.userNote = userNote;
	}
	public String getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(String inventoryId) {
		this.inventoryId = inventoryId;
	}
	
}
