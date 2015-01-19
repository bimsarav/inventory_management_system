package com.kasun.userapp.common;

/**
 * @author Kasun Kariyawasam
 *
 * Jan 3, 2015
 */
@SuppressWarnings("serial")
public class ServiceRequest<T> extends TanentMassage {
    private T payload;

    public ServiceRequest() {
    }

    public ServiceRequest(T payload) {
        this.payload = payload;
    }

    public T getPayload() {
        return this.payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }
}
