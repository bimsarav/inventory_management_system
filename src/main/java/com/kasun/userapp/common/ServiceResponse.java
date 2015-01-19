package com.kasun.userapp.common;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class ServiceResponse<T> extends TanentMassage {
    private ServiceError error;
    private List<ServiceWarning> warnings;
    private T payload;

    public ServiceResponse() {
    }

    public ServiceResponse(T payload, ServiceError error) {
        this.payload = payload;
        this.error = error;
    }

    public List<ServiceWarning> getWarnings() {
        return this.warnings;
    }

    public void setWarnings(List<ServiceWarning> warnings) {
        this.warnings = warnings;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public void addWarning(ServiceWarning warning) {
        if(this.warnings == null) {
            this.warnings = new ArrayList();
        }

        this.warnings.add(warning);
    }

    public T getPayload() {
        if(this.hasError()) {
            Throwable traceError = this.error.getTrace();
            if(traceError instanceof ServiceRuntimeException) {
                throw (ServiceRuntimeException)traceError;
            } else {
                throw new ServiceRuntimeException(this.error.getCode(), this.error.getMessage(), traceError);
            }
        } else {
            return this.payload;
        }
    }

    public ServiceError getError() {
        return this.error;
    }

    public void setError(ServiceError error) {
        this.error = error;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public boolean hasError() {
        return this.error != null;
    }

    public boolean hasWarnings() {
        return this.isNotEmpty(this.warnings);
    }

	private boolean isNotEmpty(List<ServiceWarning> warnings2) {
		// TODO Auto-generated method stub
		return false;
	}
}

