package com.kasun.userapp.reservation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/reservation/makeReservation")
public class ReservationController {
	
	private static final Logger log = LoggerFactory.getLogger(ReservationController.class);
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcomePageTemp() {
		log.debug("welcome to Make Reservation");
		return "ViewMakeReservation";
	}

}
