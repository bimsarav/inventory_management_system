package com.kasun.userapp.inventory.dao;

import java.util.List;
import java.util.Set;

import com.kasun.userapp.common.Void;
import com.kasun.userapp.inventory.dto.InventoryAddParam;
import com.kasun.userapp.inventory.dto.InventorySearchCriteria;
import com.kasun.userapp.inventory.model.Inventory;

/**
 * @author Kasun Kariyawasam
 *
 * Dec 21, 2014
 */
public interface InventoryDao {
		
	Void saveInventory(InventoryAddParam addParam);
	
	Set<InventoryAddParam> getInventoryById(String inventoryId);
	
	List<Inventory> search(InventorySearchCriteria searchCriteria);
	
	List<Inventory> viewAll();

}
