package edu.uces.ar.service.business.exception;

public class IceCreamServiceException extends RuntimeException {
	
	private static final long serialVersionUID = -4961625479507744127L;
	
	public static String ERROR_CODE = "CODIGO";
	public static String ERROR_MSG = "Mensaje";

	public IceCreamServiceException() {
        super(ERROR_MSG);
    }

	public String getErrorCode() {
		return ERROR_CODE;
	}

	public String getErrorMessage() {
		return ERROR_MSG;
	}

}
