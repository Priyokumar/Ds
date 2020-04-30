package com.yourschool.server.dto.student;

import com.yourschool.server.dto.ApiMessage;

public class StudentClassResponse {

	private StudentClass data;

	private ApiMessage apiMessage;

	public StudentClass getData() {
		return data;
	}

	public void setData(StudentClass data) {
		this.data = data;
	}

	public ApiMessage getApiMessage() {
		return apiMessage;
	}

	public void setApiMessage(ApiMessage apiMessage) {
		this.apiMessage = apiMessage;
	}

}
