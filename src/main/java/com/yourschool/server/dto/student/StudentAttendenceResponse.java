package com.yourschool.server.dto.student;

import com.yourschool.server.dto.ApiMessage;

public class StudentAttendenceResponse {

	private StudentAttendence data;

	private ApiMessage apiMessage;

	public StudentAttendence getData() {
		return data;
	}

	public void setData(StudentAttendence data) {
		this.data = data;
	}

	public ApiMessage getApiMessage() {
		return apiMessage;
	}

	public void setApiMessage(ApiMessage apiMessage) {
		this.apiMessage = apiMessage;
	}

}
