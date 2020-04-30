package com.yourschool.server.dto.employee;

public class PaySalary {

	private Long id;

	private String payDate;

	private Double paidAmount;

	private Double dueAmount;

	private EmployeeSalary employeeSalary;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPayDate() {
		return payDate;
	}

	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}

	public Double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(Double paidAmount) {
		this.paidAmount = paidAmount;
	}

	public Double getDueAmount() {
		return dueAmount;
	}

	public void setDueAmount(Double dueAmount) {
		this.dueAmount = dueAmount;
	}

	public EmployeeSalary getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(EmployeeSalary employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

}
