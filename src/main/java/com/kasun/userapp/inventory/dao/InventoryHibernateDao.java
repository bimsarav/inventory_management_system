package com.kasun.userapp.inventory.dao;

import java.util.List;

import com.kasun.userapp.common.Void;
import com.kasun.userapp.inventory.dto.InventoryAddParam;
import com.kasun.userapp.inventory.dto.InventorySearchCriteria;
import com.kasun.userapp.inventory.dto.Tenant;
import com.kasun.userapp.inventory.model.Inventory;

public class InventoryHibernateDao implements InventoryDao {

	@Override
	public Void saveInventory(InventoryAddParam addParam) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Inventory> search(InventorySearchCriteria searchCriteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Inventory> viewAll(Tenant tenant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void deleteInventory(String inventorrId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void editInventory(Inventory inventory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inventory loadInventoryById(String inventoryId) {
		// TODO Auto-generated method stub
		return null;
	}

}
