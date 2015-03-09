package com.kasun.userapp.reservation.service;

import com.kasun.userapp.common.ServiceRequest;
import com.kasun.userapp.common.ServiceResponse;
import com.kasun.userapp.inventory.model.Inventory;

public abstract interface ReservationService {
	
	ServiceResponse<Inventory> load(ServiceRequest<String> inventoryId);
}
