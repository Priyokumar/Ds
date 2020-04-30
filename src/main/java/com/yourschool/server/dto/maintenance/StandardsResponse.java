package com.yourschool.server.dto.maintenance;

import java.util.List;

import com.yourschool.server.dto.ApiMessage;

public class StandardsResponse {

	private List<Standard> data;

	private ApiMessage apiMessage;

	public List<Standard> getData() {
		return data;
	}

	public void setData(List<Standard> data) {
		this.data = data;
	}

	public ApiMessage getApiMessage() {
		return apiMessage;
	}

	public void setApiMessage(ApiMessage apiMessage) {
		this.apiMessage = apiMessage;
	}
	
}
