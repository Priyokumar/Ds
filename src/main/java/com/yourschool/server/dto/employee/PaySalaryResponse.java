package com.yourschool.server.dto.employee;

import com.yourschool.server.dto.ApiMessage;

public class PaySalaryResponse {

	private PaySalary data;

	private ApiMessage apiMessage;

	public PaySalary getData() {
		return data;
	}

	public void setData(PaySalary data) {
		this.data = data;
	}

	public ApiMessage getApiMessage() {
		return apiMessage;
	}

	public void setApiMessage(ApiMessage apiMessage) {
		this.apiMessage = apiMessage;
	}

}
