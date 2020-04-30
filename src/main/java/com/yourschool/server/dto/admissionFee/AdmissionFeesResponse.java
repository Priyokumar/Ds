package com.yourschool.server.dto.admissionFee;

import java.util.List;

import com.yourschool.server.dto.ApiMessage;

public class AdmissionFeesResponse {

	private List<Admission> data;

	private ApiMessage apiMessage;

	public List<Admission> getData() {
		return data;
	}

	public void setData(List<Admission> data) {
		this.data = data;
	}

	public ApiMessage getApiMessage() {
		return apiMessage;
	}

	public void setApiMessage(ApiMessage apiMessage) {
		this.apiMessage = apiMessage;
	}

}
