package com.kasun.userapp.inventory.logic;


import org.springframework.beans.factory.annotation.Autowired;

import com.kasun.userapp.inventory.dao.InventoryDao;
import com.kasun.userapp.inventory.model.Inventory;

public class EditInventoryLogic extends StatelessServiceLogic<Inventory,Inventory>{

	@Autowired
	private InventoryDao inventoryDao;
	
	@Override
	public Inventory invoke(Inventory inventory) {
		
		inventoryDao.editInventory(inventory);
		return inventory;
	}

	public void setInventoryDao(InventoryDao inventoryDao) {
		
		this.inventoryDao = inventoryDao;
	}
}
