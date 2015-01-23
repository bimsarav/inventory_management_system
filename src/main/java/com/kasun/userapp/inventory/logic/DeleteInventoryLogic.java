package com.kasun.userapp.inventory.logic;

import org.springframework.beans.factory.annotation.Autowired;

import com.kasun.userapp.common.Void;
import com.kasun.userapp.inventory.dao.InventoryDao;

public class DeleteInventoryLogic extends StatelessServiceLogic<Void, String> {

	@Autowired
	private InventoryDao inventoryDao;
	
	@Override
	public Void invoke(String inventoryId) {
		
		inventoryDao.deleteInventory(inventoryId);
		return new Void();
	}

	public void setInventoryDao(InventoryDao inventoryDao) {
		this.inventoryDao = inventoryDao;
	}
}
