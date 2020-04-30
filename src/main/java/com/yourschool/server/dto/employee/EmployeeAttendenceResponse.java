package com.yourschool.server.dto.employee;

import com.yourschool.server.dto.ApiMessage;

public class EmployeeAttendenceResponse {

	private EmployeeAttendence data;

	private ApiMessage apiMessage;

	public EmployeeAttendence getData() {
		return data;
	}

	public void setData(EmployeeAttendence data) {
		this.data = data;
	}

	public ApiMessage getApiMessage() {
		return apiMessage;
	}

	public void setApiMessage(ApiMessage apiMessage) {
		this.apiMessage = apiMessage;
	}

}
