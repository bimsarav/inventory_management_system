package com.kasun.userapp.reservation.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kasun.userapp.common.ServiceRequest;
import com.kasun.userapp.common.ServiceResponse;
import com.kasun.userapp.inventory.dto.Tenant;
import com.kasun.userapp.inventory.model.Inventory;
import com.kasun.userapp.inventory.service.InventoryService;
import com.kasun.userapp.reservation.service.ReservationService;

@Controller
@RequestMapping("/reservation/makeReservation")
public class ReservationController {
	
	@Autowired
	private InventoryService inventoryService;
	
	@Autowired
	private ReservationService reservationService;
	
	private static final Logger log = LoggerFactory.getLogger(ReservationController.class);
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcomePageTemp() {
		log.debug("welcome to Make Reservation");
		return "ViewMakeReservation";
	}
	
	@RequestMapping(value = "/load", method = RequestMethod.POST)
	public @ResponseBody Inventory load(@RequestBody String inventoryId) {

		Inventory inventory = new Inventory();
		ServiceRequest<String> serviceRequest = new ServiceRequest<>(inventoryId);
		ServiceResponse<Inventory> response = reservationService.load(serviceRequest);
		
		if (response.hasError()) {
			throw new RuntimeException("Error in load Inventory : "+inventoryId);
		}
		inventory = response.getPayload();
		log.info("Inventory load pass");
		return inventory;
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

	public void setInventoryService(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}

	public void setReservationService(ReservationService reservationService) {
		this.reservationService = reservationService;
	}
}
