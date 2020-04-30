package com.yourschool.server.dto.maintenance;

import java.util.List;

import com.yourschool.server.dto.ApiMessage;

public class MaintAdmissionFeesYearlyResponse {

	private List<MaintenanceAdmissionFeeYearly> data;

	private ApiMessage apiMessage;

	public List<MaintenanceAdmissionFeeYearly> getData() {
		return data;
	}

	public void setData(List<MaintenanceAdmissionFeeYearly> data) {
		this.data = data;
	}

	public ApiMessage getApiMessage() {
		return apiMessage;
	}

	public void setApiMessage(ApiMessage apiMessage) {
		this.apiMessage = apiMessage;
	}

}
