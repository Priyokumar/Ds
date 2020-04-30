package com.yourschool.server.dto.employee;

public class EmployeeSalary {

	private Long id;

	private Double salaryAmount;

	private Employee employee;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getSalaryAmount() {
		return salaryAmount;
	}

	public void setSalaryAmount(Double salaryAmount) {
		this.salaryAmount = salaryAmount;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
