package com.yourschool.server.dto.incomeAndExpense;

import java.util.List;

import com.yourschool.server.dto.ApiMessage;

public class ExpensesResponse {

	private List<Expense> data;

	private ApiMessage apiMessage;

	public List<Expense> getData() {
		return data;
	}

	public void setData(List<Expense> data) {
		this.data = data;
	}

	public ApiMessage getApiMessage() {
		return apiMessage;
	}

	public void setApiMessage(ApiMessage apiMessage) {
		this.apiMessage = apiMessage;
	}

}
