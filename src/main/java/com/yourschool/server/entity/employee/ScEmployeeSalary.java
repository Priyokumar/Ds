package com.yourschool.server.entity.employee;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SC_EMPLOYEE_SALARY")
public class ScEmployeeSalary implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "SC_ID")
	private Long id;

	@Column(name = "SALARY_AMOUNT")
	private Double salaryAmount;

	@OneToOne(fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "EMPLOYEE")
	private ScEmployee employee;

	@Embedded
	private ScRecordAudit recordAudit = new ScRecordAudit();

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

	public ScEmployee getEmployee() {
		return employee;
	}

	public void setEmployee(ScEmployee employee) {
		this.employee = employee;
	}

	public ScRecordAudit getRecordAudit() {
		return recordAudit;
	}

	public void setRecordAudit(ScRecordAudit recordAudit) {
		this.recordAudit = recordAudit;
	}

}
