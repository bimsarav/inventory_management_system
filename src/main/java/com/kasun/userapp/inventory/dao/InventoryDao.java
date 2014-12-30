package com.kasun.userapp.inventory.dao;

import java.util.Set;


import com.kasun.userapp.inventory.dto.InventoryAddParam;

/**
 * @author Kasun Kariyawasam
 *
 * Dec 21, 2014
 */
public interface InventoryDao {
		
	void saveInventory(InventoryAddParam addParam);
	
	Set<InventoryAddParam> getInventoryById(String inventoryId);

}
