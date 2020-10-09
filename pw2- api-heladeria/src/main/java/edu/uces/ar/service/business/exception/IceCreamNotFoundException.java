package edu.uces.ar.service.business.exception;

public class IceCreamNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -4961625479507744127L;
	
	public static String ERROR_CODE = "PRODUCT_NOT_PRESENT";
	public static String ERROR_MSG = "Product not present in repository";

	public IceCreamNotFoundException() {
        super(ERROR_MSG);
    }
	
	public String getErrorCode() {
		return ERROR_CODE;
	}

	public String getErrorMessage() {
		return ERROR_MSG;
	}

}
