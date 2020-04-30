package com.yourschool.server.dto.security;

import java.util.List;

import com.yourschool.server.dto.ApiMessage;
import com.yourschool.server.dto.user.Role;

public class RolesResponse {

	private List<Role> data;

	private ApiMessage apiMessage;

	public List<Role> getData() {
		return data;
	}

	public void setData(List<Role> data) {
		this.data = data;
	}

	public ApiMessage getApiMessage() {
		return apiMessage;
	}

	public void setApiMessage(ApiMessage apiMessage) {
		this.apiMessage = apiMessage;
	}
	
	
}
