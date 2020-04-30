package com.yourschool.server.dto.maintenance;

import com.yourschool.server.dto.ApiMessage;

public class MaintAdmissionFeeYearlyResponse {

	private MaintenanceAdmissionFeeYearly data;

	private ApiMessage apiMessage;

	public MaintenanceAdmissionFeeYearly getData() {
		return data;
	}

	public void setData(MaintenanceAdmissionFeeYearly data) {
		this.data = data;
	}

	public ApiMessage getApiMessage() {
		return apiMessage;
	}

	public void setApiMessage(ApiMessage apiMessage) {
		this.apiMessage = apiMessage;
	}
}
