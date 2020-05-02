package com.yourschool.server.dto.error;

import org.springframework.http.HttpStatus;

public class PreConditionFailedException extends ApiErrorException {

	private static final long serialVersionUID = 1L;

	public PreConditionFailedException(String detail) {
		super(HttpStatus.PRECONDITION_FAILED.value(), detail, HttpStatus.PRECONDITION_FAILED.name());
	}

}
