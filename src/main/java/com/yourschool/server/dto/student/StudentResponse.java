package com.yourschool.server.dto.student;

import com.yourschool.server.dto.ApiMessage;

public class StudentResponse {

	private Student data;

	private ApiMessage apiMessage;

	public ApiMessage getApiMessage() {
		return apiMessage;
	}

	public void setApiMessage(ApiMessage apiMessage) {
		this.apiMessage = apiMessage;
	}

	public Student getData() {
		return data;
	}

	public void setData(Student data) {
		this.data = data;
	}

}
