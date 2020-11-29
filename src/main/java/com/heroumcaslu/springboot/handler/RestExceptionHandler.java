package com.heroumcaslu.springboot.handler;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.heroumcaslu.springboot.error.ResourceNotFoundDetails;
import com.heroumcaslu.springboot.error.ResourceNotFoundException;
import com.heroumcaslu.springboot.error.ValidationErrorDetails;

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
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handlerMethodArgumentNotValidException(MethodArgumentNotValidException manvException) {
		
		List<FieldError> fieldErrors = manvException.getBindingResult().getFieldErrors();
		
		String fields = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(","));
		String fieldMessages = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(","));
		
		ValidationErrorDetails build = ValidationErrorDetails.builder()
		.withTimestamp(new Date().getTime())
		.withStatus(HttpStatus.BAD_REQUEST.value())
		.withTitle("Field Validation Error")
		.withDetail("Field Validation Error")
		.withDeveloperMessage(manvException.getClass().getName())
		.withField(fields)
		.withFieldMessage(fieldMessages)
		.build();
		
		return new ResponseEntity<>(build, HttpStatus.BAD_REQUEST);
		
	}

}
