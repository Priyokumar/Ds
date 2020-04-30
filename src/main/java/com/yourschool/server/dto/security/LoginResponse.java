package com.yourschool.server.dto.security;

import com.yourschool.server.dto.ApiMessage;

public class LoginResponse {

	private String token;

	private ApiMessage apiMessage;
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public ApiMessage getApiMessage() {
		return apiMessage;
	}

	public void setApiMessage(ApiMessage apiMessage) {
		this.apiMessage = apiMessage;
	}

}
