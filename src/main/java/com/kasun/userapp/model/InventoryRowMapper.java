package com.kasun.userapp.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.kasun.userapp.inventory.model.Inventory;

/**
 * @author Kasun Kariyawasam
 *
 * Jan 3, 2015
 */ 
@SuppressWarnings("rawtypes")
public class InventoryRowMapper implements RowMapper
{
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Inventory inventory = new Inventory();
		inventory.setInventoryId(rs.getString("Inventory_Id"));
		inventory.setName(rs.getString("Name"));
		inventory.setAvailableAmount(rs.getInt("Available_Amount"));
		inventory.setSoldAmount(rs.getInt("Sold_Amount"));
		inventory.setPricePerUnit(rs.getInt("Price_Per_Unit"));
		inventory.setLocation(rs.getString("Location"));
		inventory.setDescription(rs.getString("Description"));
		inventory.setCreatedDate(rs.getDate("Created_Date"));
		
		return inventory;
	}
 
}