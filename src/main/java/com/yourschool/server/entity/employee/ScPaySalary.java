package com.yourschool.server.entity.employee;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "SC_PAY_SALARY")
public class ScPaySalary implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "SC_ID")
	private Long id;

	@Column(name = "PAY_DATE")
	private Date payDate;

	@Column(name = "PAID_AMOUNT")
	private Double paidAmount;

	@Column(name = "DUE_AMOUNT")
	private Double dueAmount;
	
	@OneToOne(fetch = FetchType.EAGER,optional = true)
	@JoinColumn(name = "EMPLOYEE_SALARY")
	private ScEmployeeSalary employeeSalary;
	
	@Embedded
	private ScRecordAudit recordAudit = new ScRecordAudit();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
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

	public ScEmployeeSalary getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(ScEmployeeSalary employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public ScRecordAudit getRecordAudit() {
		return recordAudit;
	}

	public void setRecordAudit(ScRecordAudit recordAudit) {
		this.recordAudit = recordAudit;
	}

}
