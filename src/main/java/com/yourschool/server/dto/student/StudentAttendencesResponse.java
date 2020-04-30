package com.yourschool.server.dto.student;

import java.util.List;

import com.yourschool.server.dto.ApiMessage;

public class StudentAttendencesResponse {

	private List<StudentAttendence> data;

	private ApiMessage apiMessage;

	public List<StudentAttendence> getData() {
		return data;
	}

	public void setData(List<StudentAttendence> data) {
		this.data = data;
	}

	public ApiMessage getApiMessage() {
		return apiMessage;
	}

	public void setApiMessage(ApiMessage apiMessage) {
		this.apiMessage = apiMessage;
	}

}
