package com.yourschool.server.dto.incomeAndExpense;

import com.yourschool.server.dto.ApiMessage;

public class ExpenseResponse {

	private Expense data;

	private ApiMessage apiMessage;

	public ApiMessage getApiMessage() {
		return apiMessage;
	}

	public void setApiMessage(ApiMessage apiMessage) {
		this.apiMessage = apiMessage;
	}

	public Expense getData() {
		return data;
	}

	public void setData(Expense data) {
		this.data = data;
	}

}
