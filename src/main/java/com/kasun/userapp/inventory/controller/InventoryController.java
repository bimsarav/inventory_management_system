package com.kasun.userapp.inventory.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kasun.userapp.inventory.dto.InventoryAddParam;
import com.kasun.userapp.inventory.service.InventoryService;

/**
 * @author Kasun Kariyawasam
 * 
 *         Dec 21, 2014
 */

@Controller
@RequestMapping("/inventory")
public class InventoryController {
	
	
	private InventoryService inventoryService;

	private static final Logger log = LoggerFactory
			.getLogger(InventoryController.class);

	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Boolean addInventory(@RequestBody InventoryAddParam inventoryAddParam) {
		
		log.info("addInventory");
		validate(inventoryAddParam);
		inventoryService.addInventory(inventoryAddParam);
		
		return Boolean.TRUE;

	}
	
	@RequestMapping(value = "/test", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Boolean testInventory() {
		
		log.info("InventoryController test pass");
		
		return Boolean.TRUE;

	}
	
	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
	public ModelAndView welcome(@PathVariable("name") String name) {

		log.debug("welcome() - name {}", name);

		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		model.addObject("name", name);

		return model;

	}

	private void validate(InventoryAddParam inventoryAddParam) {
		// TODO Auto-generated method stub
		
	}
   
	public void setInventoryService(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}

}
