package edu.uces.ar.service.business.exception;

public class IceCreamNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -4961625479507744127L;

	public IceCreamNotFoundException(String message) {
        super(message);
    }

}
