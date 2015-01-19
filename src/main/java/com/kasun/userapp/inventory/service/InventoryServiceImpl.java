package com.kasun.userapp.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

import com.kasun.userapp.common.ServiceRequest;
import com.kasun.userapp.common.ServiceResponse;
import com.kasun.userapp.common.ServiceResponseAssembler;
import com.kasun.userapp.inventory.dao.InventoryDao;
import com.kasun.userapp.inventory.dto.InventoryAddParam;
import com.kasun.userapp.inventory.dto.InventorySearchCriteria;
import com.kasun.userapp.inventory.logic.AddInventoryLogic;
import com.kasun.userapp.inventory.logic.SearchInventoryLogic;
import com.kasun.userapp.inventory.model.Inventory;

/**
 * @author Kasun Kariyawasam
 * 
 *         Dec 21, 2014
 */
public class InventoryServiceImpl implements InventoryService {

	private AddInventoryLogic addInventoryLogic;
	
	private SearchInventoryLogic searchInventoryLogic;
	
	

	@Autowired
	private InventoryDao inventoryDao;
	
	@Override
	public ServiceResponse<List<Inventory>> searchInventory(ServiceRequest<InventorySearchCriteria> serchRequest) {
		
		return ServiceResponseAssembler.assemble(searchInventoryLogic, serchRequest);
	}

	@Override
	public ServiceResponse<com.kasun.userapp.common.Void> addInventory(ServiceRequest<InventoryAddParam> addParam) {

		return ServiceResponseAssembler.assemble(addInventoryLogic, addParam);
	}

	@Override
	public Void editInventory(InventoryAddParam editParam) {
		return null;
	}

	@Override
	public ServiceResponse<List<Inventory>> getAllInventories() {
		return ServiceResponseAssembler.assemble(searchInventoryLogic,null);
	}
	
	@Required
	public void setAddInventoryLogic(AddInventoryLogic addInventoryLogic) {
		this.addInventoryLogic = addInventoryLogic;
	}

	@Required
	public void setSearchInventoryLogic(SearchInventoryLogic searchInventoryLogic) {
		this.searchInventoryLogic = searchInventoryLogic;
	}

	public void setInventoryDao(InventoryDao inventoryDao) {
		this.inventoryDao = inventoryDao;
	}

}
