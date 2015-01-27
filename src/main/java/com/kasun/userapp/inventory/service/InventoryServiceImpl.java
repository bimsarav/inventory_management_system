package com.kasun.userapp.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;

import com.kasun.userapp.common.ServiceRequest;
import com.kasun.userapp.common.ServiceResponse;
import com.kasun.userapp.common.ServiceResponseAssembler;
import com.kasun.userapp.inventory.dto.InventoryAddParam;
import com.kasun.userapp.inventory.dto.InventorySearchCriteria;
import com.kasun.userapp.inventory.dto.Tenant;
import com.kasun.userapp.inventory.logic.AddInventoryLogic;
import com.kasun.userapp.inventory.logic.DeleteInventoryLogic;
import com.kasun.userapp.inventory.logic.EditInventoryLogic;
import com.kasun.userapp.inventory.logic.SearchInventoryLogic;
import com.kasun.userapp.inventory.logic.ViewAllInventoriesLogic;
import com.kasun.userapp.inventory.model.Inventory;

/**
 * @author Kasun Kariyawasam
 * 
 *         Dec 21, 2014
 */
public class InventoryServiceImpl implements InventoryService {

	private AddInventoryLogic addInventoryLogic;
	
	private SearchInventoryLogic searchInventoryLogic;
	
	private ViewAllInventoriesLogic viewAllInventoriesLogic;
	
	private DeleteInventoryLogic deleteInventoryLogic;
	
	private EditInventoryLogic editInventoryLogic;
	
	@Override
	public ServiceResponse<List<Inventory>> searchInventory(ServiceRequest<InventorySearchCriteria> serchRequest) {
		
		return ServiceResponseAssembler.assemble(searchInventoryLogic, serchRequest);
	}

	@Override
	public ServiceResponse<com.kasun.userapp.common.Void> addInventory(ServiceRequest<InventoryAddParam> addParam) {

		return ServiceResponseAssembler.assemble(addInventoryLogic, addParam);
	}


	@Override
	public ServiceResponse<List<Inventory>> viewAllInventories(ServiceRequest<Tenant> tenant) {
		
		return ServiceResponseAssembler.assemble(viewAllInventoriesLogic, tenant);
	}
	
	@Override
	public ServiceResponse<com.kasun.userapp.common.Void> deleteInventory(ServiceRequest<String> inventoryId) {
		
		return ServiceResponseAssembler.assemble(deleteInventoryLogic, inventoryId);
	}
	
	@Override
	public ServiceResponse<Inventory> editInventory(ServiceRequest<Inventory> editRequest) {
		
		return ServiceResponseAssembler.assemble(editInventoryLogic, editRequest);
	}
	
	@Required
	public void setAddInventoryLogic(AddInventoryLogic addInventoryLogic) {
		
		this.addInventoryLogic = addInventoryLogic;
	}

	@Required
	public void setSearchInventoryLogic(SearchInventoryLogic searchInventoryLogic) {
		
		this.searchInventoryLogic = searchInventoryLogic;
	}
	
	@Required
	public void setViewAllInventoriesLogic(ViewAllInventoriesLogic viewAllInventoriesLogic) {
		
		this.viewAllInventoriesLogic = viewAllInventoriesLogic;
	}

	@Required
	public void setDeleteInventoryLogic(DeleteInventoryLogic deleteInventoryLogic) {
		
		this.deleteInventoryLogic = deleteInventoryLogic;
	}
}
