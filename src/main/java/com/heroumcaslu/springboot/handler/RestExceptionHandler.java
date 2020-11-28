package com.heroumcaslu.springboot.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.heroumcaslu.springboot.error.ResourceNotFoundDetails;
import com.heroumcaslu.springboot.error.ResourceNotFoundException;

@ControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handlerResourceNotFoundException(ResourceNotFoundException rnfException) {
		
		ResourceNotFoundDetails build = ResourceNotFoundDetails.builder()
		.withTimestamp(new Date().getTime())
		.withStatus(HttpStatus.NOT_FOUND.value())
		.withTitle("Resource not found")
		.withDetail(rnfException.getMessage())
		.withDeveloperMessage(rnfException.getClass().getName())
		.build();
		
		return new ResponseEntity<>(build, HttpStatus.NOT_FOUND);
		
	}

}
