package com.kasun.userapp.common;

import java.util.List;

public abstract class ServiceResponseAssembler {
	
    public ServiceResponseAssembler() {
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T, V> ServiceResponse<T> assemble(ServiceLogic<T, V> serviceLogic, ServiceRequest<V> serviceRequest) {
        ServiceResponse response = new ServiceResponse();
        Object result = serviceLogic.invoke(serviceRequest.getPayload());
        populateWarnings(response, serviceLogic);
        response.setPayload(result);
        return response;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	private static <T, V> boolean populateWarnings(ServiceResponse<T> response, ServiceLogic<T, V> serviceLogic) {
        List warnings = serviceLogic.getWarnings();
        if(!warnings.isEmpty()) {
            response.setWarnings(warnings);
        }

        return warnings.isEmpty();
    }
}
