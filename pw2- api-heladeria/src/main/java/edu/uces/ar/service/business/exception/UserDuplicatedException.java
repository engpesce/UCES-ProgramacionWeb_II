package edu.uces.ar.service.business.exception;

public class UserDuplicatedException extends RuntimeException {
	
	private static final long serialVersionUID = -7761101123268246860L;

	public UserDuplicatedException(String message) {
        super(message);
    }

}
