package com.kasun.userapp.inventory.dao;

import java.util.List;

import com.kasun.userapp.common.Void;
import com.kasun.userapp.inventory.dto.InventoryAddParam;
import com.kasun.userapp.inventory.dto.InventorySearchCriteria;
import com.kasun.userapp.inventory.dto.Tenant;
import com.kasun.userapp.inventory.model.Inventory;

/**
 * @author Kasun Kariyawasam
 *
 * Dec 21, 2014
 */
public interface InventoryDao {
	
	Inventory loadInventoryById(String inventoryId);
		
	Void saveInventory(InventoryAddParam addParam);
	
	List<Inventory> search(InventorySearchCriteria searchCriteria);
	
	List<Inventory> viewAll(Tenant tenant);
	
	Void deleteInventory(String inventorrId);
	
	Void editInventory(Inventory inventory);

}
