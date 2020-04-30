package com.yourschool.server.dto.employee;

import java.util.List;

import com.yourschool.server.dto.ApiMessage;

public class StaffsResponse {

	private List<Staff> data;

	private ApiMessage apiMessage;

	public List<Staff> getData() {
		return data;
	}

	public void setData(List<Staff> data) {
		this.data = data;
	}

	public ApiMessage getApiMessage() {
		return apiMessage;
	}

	public void setApiMessage(ApiMessage apiMessage) {
		this.apiMessage = apiMessage;
	}

}
