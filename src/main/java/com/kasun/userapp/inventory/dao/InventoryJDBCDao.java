package com.kasun.userapp.inventory.dao;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.jdbc.core.JdbcTemplate;

import com.kasun.userapp.common.Void;
import com.kasun.userapp.inventory.dto.InventoryAddParam;
import com.kasun.userapp.inventory.dto.InventorySearchCriteria;
import com.kasun.userapp.inventory.dto.Tenant;
import com.kasun.userapp.inventory.model.Inventory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Kasun Kariyawasam
 * 
 *         Dec 21, 2014
 */
public class InventoryJDBCDao implements InventoryDao {

	private static final Logger log = LoggerFactory
			.getLogger(InventoryJDBCDao.class);

	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public Void saveInventory(InventoryAddParam addParam) {

		String sql = "INSERT INTO inventoryData VALUES (?, ?, ?, ?,?,?)";
		jdbcTemplateObject.update(sql, addParam.getInventoryId(),
				addParam.getName(), Integer.parseInt(addParam.getPrice()),
				addParam.getHospital(), addParam.getUserNote(), new Date());

		log.info("Inventory Saved Succesfully");
		return new Void();

	}

	@Override
	public List<Inventory> search(InventorySearchCriteria searchCriteria) {

		List<Inventory> searchResults = new ArrayList<>();
		String sql = "SELECT * FROM inventoryData";
		
		if(searchCriteria != null || isAllFieldsNotEmpty(searchCriteria)){
			sql = sql +  " WHERE ";
			
			if(!searchCriteria.getInventoryId().isEmpty()){
				sql = sql + "Inventory_Id = '"+searchCriteria.getInventoryId() +"' ";
			}
			
			if(!searchCriteria.getInventoryName().isEmpty()){
				sql = sql + "AND Name = '"+searchCriteria.getInventoryName() +"' ";
			}
			
			if(!searchCriteria.getPrice().isEmpty()){
				sql = sql +"AND Price = '"+searchCriteria.getPrice()+"' ";
			}
			
			if(!searchCriteria.getHospital().isEmpty()){
				sql = sql + "AND Hospital = '"+searchCriteria.getHospital() +"' ";
			}
		}
		
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

//		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql,
//				searchCriteria.getInventoryId(),
//				searchCriteria.getInventoryName(), 
//				searchCriteria.getPrice(),
//				searchCriteria.getHospital());

		for (@SuppressWarnings("rawtypes")
		Map row : rows) {
			Inventory inventory = new Inventory();
			inventory.setInventoryId((String) (row.get("Inventory_Id")));
			inventory.setName((String) (row.get("Name")));
			inventory.setPrice((Integer) (row.get("Price")));
			inventory.setHospital((String) (row.get("Hospital")));
			inventory.setUserNote((String) (row.get("User_Note")));
			inventory.setCreatedDate((Date) (row.get("Created_Date")));

			searchResults.add(inventory);
		}
		return searchResults;
	}

	private boolean isAllFieldsNotEmpty(Object obj) {
		
		for (Field field : obj.getClass().getDeclaredFields()) {
	        if (!field.isAccessible()) {
	            field.setAccessible(true);
	        }
	        
	        // Danger!
	        String str;
			try {
				str = (String) field.get(obj);
				if (!str.isEmpty()) {
		            return true;
		        }
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    return false;
	}

	@Override
	public Set<InventoryAddParam> getInventoryById(String inventoryId) {
		return null;
	}

	@Required
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	private JdbcTemplate getJdbcTemplate() {
		return this.jdbcTemplateObject;
	}

	@Override
	public List<Inventory> viewAll(Tenant tenant) {

		List<Inventory> searchResults = new ArrayList<>();
		String sql = "SELECT * FROM inventoryData ";

		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

		for (@SuppressWarnings("rawtypes")
		Map row : rows) {

			Inventory inventory = new Inventory();
			inventory.setInventoryId((String) (row.get("Inventory_Id")));
			inventory.setName((String) (row.get("Name")));
			inventory.setPrice((Integer) (row.get("Price")));
			inventory.setHospital((String) (row.get("Hospital")));
			inventory.setUserNote((String) (row.get("User_Note")));
			inventory.setCreatedDate((Date) (row.get("Created_Date")));

			searchResults.add(inventory);

		}
		return searchResults;
	}
}
