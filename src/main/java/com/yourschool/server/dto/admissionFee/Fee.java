package com.yourschool.server.dto.admissionFee;

public class Fee {

	private Long id;

	private String feeRefNo;

	private String status;

	private Double amount;

	private String exptdateOfPayment;

	private String actdateOfPayment;

	private String monthOf;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFeeRefNo() {
		return feeRefNo;
	}

	public void setFeeRefNo(String feeRefNo) {
		this.feeRefNo = feeRefNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getExptdateOfPayment() {
		return exptdateOfPayment;
	}

	public void setExptdateOfPayment(String exptdateOfPayment) {
		this.exptdateOfPayment = exptdateOfPayment;
	}

	public String getActdateOfPayment() {
		return actdateOfPayment;
	}

	public void setActdateOfPayment(String actdateOfPayment) {
		this.actdateOfPayment = actdateOfPayment;
	}

	public String getMonthOf() {
		return monthOf;
	}

	public void setMonthOf(String monthOf) {
		this.monthOf = monthOf;
	}

}
