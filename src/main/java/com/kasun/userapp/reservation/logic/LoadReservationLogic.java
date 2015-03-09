package com.kasun.userapp.reservation.logic;

import org.springframework.beans.factory.annotation.Required;

import com.kasun.userapp.inventory.dao.InventoryDao;
import com.kasun.userapp.inventory.logic.StatelessServiceLogic;
import com.kasun.userapp.inventory.model.Inventory;

public class LoadReservationLogic extends StatelessServiceLogic<Inventory,String>{

	private InventoryDao inventoryDao;
	
	@Override
	public Inventory invoke(String inventoryId) {
		
		Inventory inventory = inventoryDao.loadInventoryById(inventoryId);
		validate(inventory);
		return inventory;
	}

	private void validate(Inventory inventory) {
		
		if(inventory == null){
			throw new RuntimeException("Inventory is null");
		}
	}

	@Required
	public void setInventoryDao(InventoryDao inventoryDao) {
		this.inventoryDao = inventoryDao;
	}
}
