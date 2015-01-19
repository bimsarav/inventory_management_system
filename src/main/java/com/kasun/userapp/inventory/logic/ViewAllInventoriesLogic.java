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
 * Jan 4, 2015
 */
public class ViewAllInventoriesLogic extends StatelessServiceLogic<List<Inventory>,InventorySearchCriteria>{

	@Autowired
	private InventoryDao inventoryDao;
	
	@Override
	public List<Inventory> invoke(InventorySearchCriteria var1) {
		
		List<Inventory> allInventories = new ArrayList<>();
		allInventories = inventoryDao.viewAll();
		validate(allInventories);
		
		return allInventories;
	}
	

	private void validate(List<Inventory> allInventories) {
		// TODO Auto-generated method stub
		
	}


	public void setInventoryDao(InventoryDao inventoryDao) {
		this.inventoryDao = inventoryDao;
	}

}
