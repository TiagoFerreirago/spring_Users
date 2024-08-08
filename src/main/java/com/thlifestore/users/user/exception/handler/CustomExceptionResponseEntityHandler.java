package com.thlifestore.users.user.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.thlifestore.users.user.exception.ResponseException;

@RestController
@ControllerAdvice
public class CustomExceptionResponseEntityHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseException> genericExceptionHandler(Exception ex, WebRequest web){
		ResponseException response = new ResponseException(ex.getMessage(), web.getDescription(false), new Date());
		return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(CustomNotFoundExceptionHandler.class)
	public ResponseEntity<ResponseException> notFoundExceptionHandler(Exception ex, WebRequest web){
		ResponseException response = new ResponseException(ex.getMessage(), web.getDescription(false), new Date());
		return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
	}
	
}
