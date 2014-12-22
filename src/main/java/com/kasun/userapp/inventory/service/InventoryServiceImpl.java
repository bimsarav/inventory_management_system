package com.kasun.userapp.inventory.service;

import org.springframework.beans.factory.annotation.Required;

import com.kasun.userapp.inventory.dao.InventoryDao;
import com.kasun.userapp.inventory.dto.InventoryAddParam;
import com.kasun.userapp.inventory.logic.AddInventoryLogic;

/**
 * @author Kasun Kariyawasam
 *
 * Dec 21, 2014
 */
public class InventoryServiceImpl implements InventoryService {

	@SuppressWarnings("unused")
	private AddInventoryLogic addInventoryLogic;
	
	private InventoryDao inventoryDao;
	
	@Override
	public void addInventory(InventoryAddParam addParam) {
		
		inventoryDao.saveInventory(addParam);

	}

	@Override
	public void editInventory(InventoryAddParam editParam) {
		// TODO Auto-generated method stub
		
	}

	@Required
	public void setAddInventoryLogic(AddInventoryLogic addInventoryLogic) {
		this.addInventoryLogic = addInventoryLogic;
	}

	@Required
	public void setInventoryDao(InventoryDao inventoryDao) {
		this.inventoryDao = inventoryDao;
	}
	
}
