package com.taxy.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.MethodArgumentNotValidException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(
            MethodArgumentNotValidException exception) {

        Map<String, String> errors = new HashMap<>();

        exception.getBindingResult()
                 .getFieldErrors()
                 .forEach(error ->
                     errors.put(
                         error.getField(),
                         error.getDefaultMessage()
                     )
                 );

        return errors;
    }
	
	@ExceptionHandler(TaxActivityNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Map<String, String> handleTaxActivityNotFound(
	        TaxActivityNotFoundException exception) {

	    Map<String, String> error = new HashMap<>();
	    error.put("message", exception.getMessage());

	    return error;
	}

}
