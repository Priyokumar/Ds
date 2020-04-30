package com.yourschool.server.dto;

import org.springframework.http.HttpStatus;

public class ApiUtil {

	public static ApiMessage okMessage(String detail) {

		return new ApiMessage(false, HttpStatus.OK.value(), detail, HttpStatus.OK.name());
	}

	public static ApiMessage createdMessage(String detail) {

		return new ApiMessage(false, HttpStatus.CREATED.value(), detail, HttpStatus.CREATED.name());
	}
	
}
