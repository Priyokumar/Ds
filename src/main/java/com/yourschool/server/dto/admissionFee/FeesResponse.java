package com.yourschool.server.dto.admissionFee;

import java.util.List;

import com.yourschool.server.dto.ApiMessage;

public class FeesResponse {

	private List<Fee> data;

	private ApiMessage apiMessage;

	public List<Fee> getData() {
		return data;
	}

	public void setData(List<Fee> data) {
		this.data = data;
	}

	public ApiMessage getApiMessage() {
		return apiMessage;
	}

	public void setApiMessage(ApiMessage apiMessage) {
		this.apiMessage = apiMessage;
	}
}
