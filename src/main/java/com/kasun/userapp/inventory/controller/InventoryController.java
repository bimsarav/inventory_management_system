package com.kasun.userapp.inventory.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kasun.userapp.common.ServiceRequest;
import com.kasun.userapp.common.ServiceResponse;
import com.kasun.userapp.inventory.dto.InventoryAddParam;
import com.kasun.userapp.inventory.dto.InventorySearchCriteria;
import com.kasun.userapp.inventory.dto.Tenant;
import com.kasun.userapp.inventory.model.Inventory;
import com.kasun.userapp.inventory.service.InventoryService;

/**
 * @author Kasun Kariyawasam
 * 
 *         Dec 21, 2014
 */

@Controller
@RequestMapping("/inventory")
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;

	private static final Logger log = LoggerFactory.getLogger(InventoryController.class);

	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody String addInventory(@RequestBody InventoryAddParam inventoryAddParam) {

		validate(inventoryAddParam);
		System.out.println("Success " + inventoryAddParam.getName());
		ServiceRequest<InventoryAddParam> serviceRequest = convertAddParamtoServiceRequest(inventoryAddParam);
		inventoryService.addInventory(serviceRequest);
		return "Inventory Added Succesfully";
	}
	

	@RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody String deleteInventory(@RequestBody String inventoryId) {

		ServiceRequest<String> serviceRequest = new ServiceRequest<>(
				inventoryId);
		inventoryService.deleteInventory(serviceRequest);
		return "Inventory Deleted Succesfully";
	}
	

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcomePageTemp() {
		log.debug("welcome");
		return "inventory";
	}
	
	@RequestMapping(value = "/add_edit_view", method = RequestMethod.GET)
	public String add_edit_view_page() {
		log.debug("view/edit/add");
		return "addViewEditInventory";
	}
	

	@RequestMapping(value = "/viewAll", method = RequestMethod.POST)
	public @ResponseBody List<Inventory> viewInventory(@RequestBody Tenant tanent) {

		List<Inventory> inventories = new ArrayList<>();
		ServiceRequest<Tenant> serviceRequest = new ServiceRequest<>(tanent);
		ServiceResponse<List<Inventory>> response = inventoryService.viewAllInventories(serviceRequest);
		
		if (response.hasError()) {
			throw new RuntimeException("Error in View All Inventories");
		}
		inventories = response.getPayload();
		log.info("Inventory view all pass");
		return inventories;
	}
	

	@RequestMapping(value = "/search", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody List<Inventory> searchInventory(@RequestBody InventorySearchCriteria searchCriteria) {

		List<Inventory> inventories = new ArrayList<>();
		ServiceRequest<InventorySearchCriteria> serchRequest = new ServiceRequest<InventorySearchCriteria>();
		serchRequest.setPayload(searchCriteria);
		ServiceResponse<List<Inventory>> response = inventoryService.searchInventory(serchRequest);
		
		if (response.hasError()) {
			throw new RuntimeException("Error in search...");
		}
		validateSearchResulit(response);
		log.info("Inventory search pass");
		inventories = response.getPayload();
		return inventories;
	}
	
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody Inventory editInventory(@RequestBody Inventory inventory) {

		ServiceRequest<Inventory> editRequest = new ServiceRequest<Inventory>(inventory);
		ServiceResponse<Inventory> response = inventoryService.editInventory(editRequest);

		if (response.hasError()) {
			throw new RuntimeException("Error in Edition");
		}
		log.info("Inventory Edit pass");
		return response.getPayload();
	}
	
	
	private ServiceRequest<InventoryAddParam> convertAddParamtoServiceRequest(InventoryAddParam inventoryAddParam) {

		ServiceRequest<InventoryAddParam> request = new ServiceRequest<InventoryAddParam>();
		request.setPayload(inventoryAddParam);
		return request;
	}
	

	private void validateSearchResulit(ServiceResponse<List<Inventory>> response) {

	}
	

	private void validate(InventoryAddParam inventoryAddParam) {

		if (inventoryAddParam == null) {
			throw new RuntimeException("Add param can not be null");
		}

		if (inventoryAddParam.getInventoryId() == null
				|| inventoryAddParam.getInventoryId().isEmpty()) {
			throw new RuntimeException("Inventory id can not be null");
		}
	}
	

	public void setInventoryService(InventoryService inventoryService) {
		
		this.inventoryService = inventoryService;
	}
}
