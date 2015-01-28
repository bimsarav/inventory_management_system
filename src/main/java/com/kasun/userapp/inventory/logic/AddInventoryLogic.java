package com.kasun.userapp.inventory.logic;

import org.springframework.beans.factory.annotation.Autowired;

import com.kasun.userapp.inventory.dao.InventoryDao;
import com.kasun.userapp.inventory.dto.InventoryAddParam;
import com.kasun.userapp.common.Void;

/**
 * @author Kasun Kariyawasam
 * 
 *         Dec 21, 2014
 */

public class AddInventoryLogic extends StatelessServiceLogic<Void, InventoryAddParam> {

	@Autowired
	private InventoryDao inventoryDao;

	@Override
	public Void invoke(InventoryAddParam addParam) {
		
		try {
			validate(addParam);
			inventoryDao.saveInventory(addParam);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Void();
	}

	private void validate(InventoryAddParam addParam) throws Exception {

		if (addParam == null) {
			throw new Exception("Add Param is Null");
		}
	}

	public void setInventoryDao(InventoryDao inventoryDao) {
		this.inventoryDao = inventoryDao;
	}

}
