package com.yourschool.server.dto.maintenance;

import com.yourschool.server.dto.ApiMessage;

public class StandardResponse {

	private Standard data;

	private ApiMessage apiMessage;

	public ApiMessage getApiMessage() {
		return apiMessage;
	}

	public void setApiMessage(ApiMessage apiMessage) {
		this.apiMessage = apiMessage;
	}

	public Standard getData() {
		return data;
	}

	public void setData(Standard data) {
		this.data = data;
	}

	
	
}
