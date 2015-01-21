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

	private static final Logger log = LoggerFactory
			.getLogger(InventoryController.class);

	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody String addInventory(
			@RequestBody InventoryAddParam inventoryAddParam) {

		validate(inventoryAddParam);
		System.out.println("Success " + inventoryAddParam.getName());
		ServiceRequest<InventoryAddParam> serviceRequest = convertAddParamtoServiceRequest(inventoryAddParam);
		inventoryService.addInventory(serviceRequest);
		return "Inventory Added Succesfully";
	}

	private ServiceRequest<InventoryAddParam> convertAddParamtoServiceRequest(
			InventoryAddParam inventoryAddParam) {

		ServiceRequest<InventoryAddParam> request = new ServiceRequest<InventoryAddParam>();
		request.setPayload(inventoryAddParam);
		return request;
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcomePage() {

		log.debug("welcome");
		return "index";
	}

	@RequestMapping(value = "/viewAll", method = RequestMethod.GET)
	public List<Inventory> viewInventory() {

		List<Inventory> inventories = new ArrayList<>();
		ServiceResponse<List<Inventory>> response = new ServiceResponse<List<Inventory>>();
		response = inventoryService.getAllInventories();
		inventories = response.getPayload();
		log.info("Inventory view all pass");
		return inventories;

	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public List<Inventory> searchInventory(
			@RequestBody InventorySearchCriteria searchCriteria) {

		ServiceRequest<InventorySearchCriteria> serchRequest = new ServiceRequest<InventorySearchCriteria>();
		serchRequest.setPayload(searchCriteria);
		ServiceResponse<List<Inventory>> response = new ServiceResponse<List<Inventory>>();
		response = inventoryService.searchInventory(serchRequest);
		validateSearchResulit(response);
		log.info("Inventory search all pass");
		return response.getPayload();

	}

	private void validateSearchResulit(ServiceResponse<List<Inventory>> response) {
		// TODO Auto-generated method stub

	}

	private void validate(InventoryAddParam inventoryAddParam) {

		if (inventoryAddParam == null) {
			throw new RuntimeException("Add param can not be null");
		}
		
		if (inventoryAddParam.getInventoryId() == null || inventoryAddParam.getInventoryId().isEmpty()) {
			throw new RuntimeException("Inventory id can not be null");
		}
	}

	public void setInventoryService(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}

}
