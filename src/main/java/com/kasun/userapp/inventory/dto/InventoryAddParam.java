/**
 * 
 */
package com.kasun.userapp.inventory.dto;

/**
 * @author Kasun Kariyawasam
 *
 * Dec 21, 2014
 */
public class InventoryAddParam {

	private String name;
	private int price;
	private String hospital;
	private String userNote;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
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
	
}
