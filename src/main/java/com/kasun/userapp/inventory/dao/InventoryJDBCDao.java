package com.kasun.userapp.inventory.dao;

import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.jdbc.core.JdbcTemplate;

import com.kasun.userapp.inventory.dto.InventoryAddParam;

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

	private void validate(InventoryAddParam addParam) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveInventory(InventoryAddParam addParam) {

		validate(addParam);
		String sql = "INSERT INTO inventoryData VALUES (?, ?, ?, ?,?)";
		jdbcTemplateObject.update(sql, addParam.getInventoryId(),
				addParam.getName(), addParam.getPrice(),
				addParam.getHospital(), addParam.getUserNote());

		log.info("Inventory Saved Succesfully");
		
	}

	@Override
	public Set<InventoryAddParam> getInventoryById(String inventoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Required
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

}
