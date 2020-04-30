package com.yourschool.server.dto.error;

import org.springframework.http.HttpStatus;

public class InternalServerException extends ApiErrorException {

	private static final long serialVersionUID = 1L;

	public InternalServerException(String detail) {
		super(HttpStatus.INTERNAL_SERVER_ERROR.value(), detail, HttpStatus.INTERNAL_SERVER_ERROR.name());
	}
}
