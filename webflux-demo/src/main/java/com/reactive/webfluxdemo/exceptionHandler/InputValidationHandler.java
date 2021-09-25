package com.reactive.webfluxdemo.exceptionHandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.reactive.webfluxdemo.dto.InputFailedValidationResponse;
import com.reactive.webfluxdemo.exception.InputValidationException;

@ControllerAdvice
public class InputValidationHandler {

	@ExceptionHandler(InputValidationException.class)
	public ResponseEntity<InputFailedValidationResponse> handleException(InputValidationException ex) {
		
		System.out.println("asdsadads");
		
		InputFailedValidationResponse response = new InputFailedValidationResponse();
		response.setErrorCode(ex.getErrorCode());
		response.setInput(ex.getInput());
		response.setMessage(ex.getMessage());
		
		return ResponseEntity.badRequest().body(response);
	}
	
}
