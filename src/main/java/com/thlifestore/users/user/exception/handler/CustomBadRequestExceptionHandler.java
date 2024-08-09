package com.thlifestore.users.user.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CustomBadRequestExceptionHandler extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	
	public CustomBadRequestExceptionHandler() {
		super("Invalid request: check the parameters provided.");
	}

}
