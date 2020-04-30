package com.yourschool.server.dto.employee;

import java.util.ArrayList;
import java.util.List;

import com.yourschool.server.dto.ApiMessage;

public class EmployeeSalariesResponse {

	private List<EmployeeSalary> data = new ArrayList<EmployeeSalary>();

	private ApiMessage apiMessage;

	public List<EmployeeSalary> getData() {
		return data;
	}

	public void setData(List<EmployeeSalary> data) {
		this.data = data;
	}

	public ApiMessage getApiMessage() {
		return apiMessage;
	}

	public void setApiMessage(ApiMessage apiMessage) {
		this.apiMessage = apiMessage;
	}

}
