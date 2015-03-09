package com.kasun.userapp.reservation.service;

import org.springframework.beans.factory.annotation.Required;

import com.kasun.userapp.common.ServiceRequest;
import com.kasun.userapp.common.ServiceResponse;
import com.kasun.userapp.common.ServiceResponseAssembler;
import com.kasun.userapp.inventory.model.Inventory;
import com.kasun.userapp.reservation.logic.LoadReservationLogic;

public class ReservationServiceImpl implements ReservationService {

	private LoadReservationLogic loadReservationLogic;
	
	@Override
	public ServiceResponse<Inventory> load(ServiceRequest<String> inventoryId) {
		
		return ServiceResponseAssembler.assemble(loadReservationLogic, inventoryId);
	}

	@Required
	public void setLoadReservationLogic(LoadReservationLogic loadReservationLogic) {
		this.loadReservationLogic = loadReservationLogic;
	}
}
