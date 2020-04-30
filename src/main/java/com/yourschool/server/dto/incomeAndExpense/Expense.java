package com.yourschool.server.dto.incomeAndExpense;

public class Expense {

	private Long id;

	private String refNo;

	private Double amount;

	private String expenseType;

	private String expenseDetails;

	private String comments;

	private String expenseDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}

	public String getExpenseDetails() {
		return expenseDetails;
	}

	public void setExpenseDetails(String expenseDetails) {
		this.expenseDetails = expenseDetails;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getExpenseDate() {
		return expenseDate;
	}

	public void setExpenseDate(String expenseDate) {
		this.expenseDate = expenseDate;
	}

}
