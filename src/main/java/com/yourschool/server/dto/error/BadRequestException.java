package com.yourschool.server.dto.error;

import org.springframework.http.HttpStatus;

public class BadRequestException extends ApiErrorException {

	private static final long serialVersionUID = 1L;

	public BadRequestException(String detail) {
		super(HttpStatus.BAD_REQUEST.value(), detail, HttpStatus.BAD_REQUEST.name());
	}
	
	
}
