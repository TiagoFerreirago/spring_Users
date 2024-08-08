package com.thlifestore.users.user.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomNotFoundExceptionHandler extends RuntimeException {

	private static final long serialVersionUID = 1L;

	
	public CustomNotFoundExceptionHandler(String msg) {
		super(msg);
	}
}
