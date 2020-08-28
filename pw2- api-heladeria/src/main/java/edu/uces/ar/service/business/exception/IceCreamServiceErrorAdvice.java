package edu.uces.ar.service.business.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import edu.uces.ar.ApiRestHeladeriaApplication;

@ControllerAdvice
public class IceCreamServiceErrorAdvice {

	private static final Logger logger = LoggerFactory.getLogger(ApiRestHeladeriaApplication.class);
	
	@ExceptionHandler({RuntimeException.class})
    public ResponseEntity<String> handleRunTimeException(RuntimeException e) {
        return error(HttpStatus.INTERNAL_SERVER_ERROR, e);
    }
	
    @ExceptionHandler({IceCreamNotFoundException.class})
    public ResponseEntity<String> handleNotFoundException(IceCreamNotFoundException e) {
        return error(HttpStatus.NOT_FOUND, e);
    }
    
    @ExceptionHandler({IceCreamServiceException.class})
    public ResponseEntity<String> handleDogsServiceException(IceCreamServiceException e){
        return error(HttpStatus.INTERNAL_SERVER_ERROR, e);
    }
    
    @ExceptionHandler({UserDuplicatedException.class})
    public ResponseEntity<String> handleDuplicatedException(UserDuplicatedException e) {
        return error(HttpStatus.BAD_REQUEST, e);
    }
    
    private ResponseEntity<String> error(HttpStatus status, Exception e) {
    	logger.error("Exception : ", e);
        return ResponseEntity.status(status).body(e.getMessage());
    }
}
