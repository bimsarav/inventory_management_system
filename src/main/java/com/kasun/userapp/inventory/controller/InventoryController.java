package com.kasun.userapp.inventory.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
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
	
	@Autowired
	private InventoryService inventoryService;

	private static final Logger log = LoggerFactory
			.getLogger(InventoryController.class);

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addInventory(@RequestBody InventoryAddParam inventoryAddParam) {
		
		log.info("addInventory");
		validate(inventoryAddParam);
		inventoryService.addInventory(inventoryAddParam);
		
		return "test";

	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String testInventory() {
		
		InventoryAddParam inventoryAddParam = new InventoryAddParam();
		
		inventoryAddParam.setInventoryId("testId001");
		inventoryAddParam.setName("testName");
		inventoryAddParam.setPrice(1000);
		inventoryAddParam.setUserNote("testNote");
		inventoryAddParam.setHospital("testHospital");
		
		inventoryService.addInventory(inventoryAddParam);
		
		log.info("InventoryController test pass");
		
		return "test";

	}
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcomePage() {

		log.debug("welcome");
		
//		ModelAndView model = new ModelAndView();
//		model.setViewName("index");
//		model.addObject("name", name);

		return "index";

	}
	
	
//	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
//	public ModelAndView welcome(@PathVariable("name") String name) {
//
//		log.debug("welcome() - name {}", name);
//
//		ModelAndView model = new ModelAndView();
//		model.setViewName("index");
//		model.addObject("name", name);
//
//		return model;
//
//	}

	private void validate(InventoryAddParam inventoryAddParam) {
		// TODO Auto-generated method stub
		
	}
   
	public void setInventoryService(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}

}
