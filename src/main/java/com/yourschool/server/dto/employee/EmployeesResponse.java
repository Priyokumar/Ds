package com.yourschool.server.dto.employee;

import java.util.ArrayList;
import java.util.List;

import com.yourschool.server.dto.ApiMessage;

public class EmployeesResponse {

	private List<Employee> data = new ArrayList<>();

	private ApiMessage apiMessage;

	public List<Employee> getData() {
		return data;
	}

	public void setData(List<Employee> data) {
		this.data = data;
	}

	public ApiMessage getApiMessage() {
		return apiMessage;
	}

	public void setApiMessage(ApiMessage apiMessage) {
		this.apiMessage = apiMessage;
	}

}
