package com.kasun.userapp.inventory.logic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kasun.userapp.inventory.dao.InventoryDao;
import com.kasun.userapp.inventory.dto.InventorySearchCriteria;
import com.kasun.userapp.inventory.model.Inventory;

/**
 * @author Kasun Kariyawasam
 *
 * Jan 3, 2015
 */
public class SearchInventoryLogic extends StatelessServiceLogic<List<Inventory>,InventorySearchCriteria>{
	
	@Autowired
	private InventoryDao inventoryDao;
	
	@Override
	public List<Inventory> invoke(InventorySearchCriteria searchCriteria) {
		
		validate(searchCriteria); 
		List<Inventory> inventories = new ArrayList<>();
		inventories = inventoryDao.search(searchCriteria);
		
		return inventories;
	}

	private void validate(InventorySearchCriteria searchCriteria) {
		// TODO Auto-generated method stub
		
	}

	public void setInventoryDao(InventoryDao inventoryDao) {
		this.inventoryDao = inventoryDao;
	}
	
}
