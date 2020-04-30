package com.yourschool.server.dto;

public class ActionResponse {

	private String actionMessage;

	private ApiMessage apiMessage;

	public String getActionMessage() {
		return actionMessage;
	}

	public void setActionMessage(String actionMessage) {
		this.actionMessage = actionMessage;
	}

	public ApiMessage getApiMessage() {
		return apiMessage;
	}

	public void setApiMessage(ApiMessage apiMessage) {
		this.apiMessage = apiMessage;
	}

}
