package com.yourschool.server.dto.employee;

import com.yourschool.server.dto.ApiMessage;

public class EmployeeSalaryResponse {

	private EmployeeSalary data;

	private ApiMessage apiMessage;

	public ApiMessage getApiMessage() {
		return apiMessage;
	}

	public void setApiMessage(ApiMessage apiMessage) {
		this.apiMessage = apiMessage;
	}

	public EmployeeSalary getData() {
		return data;
	}

	public void setData(EmployeeSalary data) {
		this.data = data;
	}

}
