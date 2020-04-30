package com.yourschool.server.dto.employee;

import java.util.List;

import com.yourschool.server.dto.ApiMessage;

public class EmployeeAttendencesResponse {

	private List<EmployeeAttendence> data;

	private ApiMessage apiMessage;

	public List<EmployeeAttendence> getData() {
		return data;
	}

	public void setData(List<EmployeeAttendence> data) {
		this.data = data;
	}

	public ApiMessage getApiMessage() {
		return apiMessage;
	}

	public void setApiMessage(ApiMessage apiMessage) {
		this.apiMessage = apiMessage;
	}

}
