package com.kasun.userapp.inventory.service;

import java.util.List;

import com.kasun.userapp.common.ServiceRequest;
import com.kasun.userapp.common.ServiceResponse;
import com.kasun.userapp.inventory.dto.InventoryAddParam;
import com.kasun.userapp.inventory.dto.InventorySearchCriteria;
import com.kasun.userapp.inventory.dto.Tenant;
import com.kasun.userapp.inventory.model.Inventory;

/**
 * @author Kasun Kariyawasam
 *
 * Dec 21, 2014
 */

public abstract interface InventoryService {
	
	ServiceResponse<com.kasun.userapp.common.Void> addInventory(ServiceRequest<InventoryAddParam> inventoryAddRequest);
	
	ServiceResponse<Inventory> editInventory(ServiceRequest<Inventory> editRequest);
	
	ServiceResponse<List<Inventory>> viewAllInventories(ServiceRequest<Tenant> tenant);
	
	ServiceResponse<List<Inventory>> searchInventory(ServiceRequest<InventorySearchCriteria> serchRequest);

	ServiceResponse<com.kasun.userapp.common.Void> deleteInventory(ServiceRequest<String> serviceRequest);
	
}
