package edu.uces.ar.service.business.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import edu.uces.ar.ApiRestHeladeriaApplication;
import edu.uces.ar.model.dto.ErrorAPI;

@ControllerAdvice
public class IceCreamServiceErrorAdvice {

	private static final Logger logger = LoggerFactory.getLogger(ApiRestHeladeriaApplication.class);
	
	@ExceptionHandler({RuntimeException.class})
    public ResponseEntity<ErrorAPI> handleRunTimeException(RuntimeException e) {
        return error(HttpStatus.INTERNAL_SERVER_ERROR, "RUNTIME", e.getMessage());
    }
	
    @ExceptionHandler({IceCreamNotFoundException.class})
    public ResponseEntity<ErrorAPI> handleNotFoundException(IceCreamNotFoundException e) {
        return error(HttpStatus.NOT_FOUND, e.getErrorCode(), e.getErrorMessage());
    }
    
    @ExceptionHandler({IceCreamServiceException.class})
    public ResponseEntity<ErrorAPI> handleDogsServiceException(IceCreamServiceException e){
        return error(HttpStatus.INTERNAL_SERVER_ERROR, e.getErrorCode(), e.getErrorMessage());
    }
    
    private ResponseEntity<ErrorAPI> error(HttpStatus status, String errorCode, String errorMessage) {
    	logger.error("Exception : " + status + " - " + errorCode);
        return ResponseEntity.status(status).body(new ErrorAPI(errorCode, errorMessage));
    }
}
