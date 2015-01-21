package com.kasun.userapp.inventory.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

import com.kasun.userapp.inventory.dao.InventoryDao;
import com.kasun.userapp.inventory.dto.Tenant;
import com.kasun.userapp.inventory.model.Inventory;

/**
 * @author Kasun Kariyawasam
 *
 * Jan 21, 2015
 */
public class GetAllInventories extends StatelessServiceLogic<List<Inventory>,Tenant>{

	@Autowired
	private InventoryDao inventoryDao;
	
	@Override
	public List<Inventory> invoke(Tenant tenant) {
		
		
		
		return null;
	}

	@Required
	public void setInventoryDao(InventoryDao inventoryDao) {
		this.inventoryDao = inventoryDao;
	}
}
