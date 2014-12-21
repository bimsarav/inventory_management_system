package com.kasun.userapp.inventory.service;

import com.kasun.userapp.inventory.dto.InventoryAddParam;

/**
 * @author Kasun Kariyawasam
 *
 * Dec 21, 2014
 */
public abstract interface InventoryService {
	
	void addInventory(InventoryAddParam addParam);
	
	void editInventory(InventoryAddParam editParam);
	
//	InventorySearchResult searchInventory(InventorySearchParam);
	
}
