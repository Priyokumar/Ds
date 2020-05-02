package com.yourschool.server.dto.error;

import org.springframework.http.HttpStatus;

public class UnAuthorizedException extends ApiErrorException {

	private static final long serialVersionUID = 1L;

	public UnAuthorizedException(String detail) {
		super(HttpStatus.UNAUTHORIZED.value(), detail, HttpStatus.UNAUTHORIZED.name());
	}

}
