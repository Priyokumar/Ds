package com.yourschool.server.dto.incomeAndExpense;

public class Income {

	private Long id;

	private String refNo;

	private Double amount;

	private String incomeType;

	private String incomeDetails;

	private String comments;

	private String incomeDate;

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

	public String getIncomeType() {
		return incomeType;
	}

	public void setIncomeType(String incomeType) {
		this.incomeType = incomeType;
	}

	public String getIncomeDetails() {
		return incomeDetails;
	}

	public void setIncomeDetails(String incomeDetails) {
		this.incomeDetails = incomeDetails;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getIncomeDate() {
		return incomeDate;
	}

	public void setIncomeDate(String incomeDate) {
		this.incomeDate = incomeDate;
	}

}
