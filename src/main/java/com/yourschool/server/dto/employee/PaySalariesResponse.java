package com.yourschool.server.dto.employee;

import java.util.ArrayList;
import java.util.List;

import com.yourschool.server.dto.ApiMessage;

public class PaySalariesResponse {

	private List<PaySalary> data = new ArrayList<>();

	private ApiMessage apiMessage;

	public List<PaySalary> getData() {
		return data;
	}

	public void setData(List<PaySalary> data) {
		this.data = data;
	}

	public ApiMessage getApiMessage() {
		return apiMessage;
	}

	public void setApiMessage(ApiMessage apiMessage) {
		this.apiMessage = apiMessage;
	}

}
