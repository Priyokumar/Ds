package com.yourschool.server.dto.employee;

import com.yourschool.server.dto.ApiMessage;

public class EmployeeResponse {

	private Employee data;

	private ApiMessage apiMessage;

	public Employee getData() {
		return data;
	}

	public void setData(Employee data) {
		this.data = data;
	}

	public ApiMessage getApiMessage() {
		return apiMessage;
	}

	public void setApiMessage(ApiMessage apiMessage) {
		this.apiMessage = apiMessage;
	}

}
