package com.yourschool.server.dto.employee;

import com.yourschool.server.dto.ApiMessage;

public class StaffResponse {

	private Staff data;

	private ApiMessage apiMessage;

	public Staff getData() {
		return data;
	}

	public void setData(Staff data) {
		this.data = data;
	}

	public ApiMessage getApiMessage() {
		return apiMessage;
	}

	public void setApiMessage(ApiMessage apiMessage) {
		this.apiMessage = apiMessage;
	}

}
