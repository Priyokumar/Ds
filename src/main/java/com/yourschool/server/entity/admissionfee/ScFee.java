package com.yourschool.server.entity.admissionfee;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SC_FEE")
public class ScFee implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "SC_ID")
	private Long id;

	@Column(name = "FEE_REF_NO")
	private String feeRefNo;

	@Column(name = "status")
	private String status;

	@Column(name = "AMOUNT")
	private Double amount;

	@Column(name = "EXPT_DATE_OF_PAYMENT")
	private Date exptdateOfPayment;

	@Column(name = "ACT_DATE_OF_PAYMENT")
	private Date actdateOfPayment;

	@Column(name = "MONTH_OF")
	private String monthOf;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ADMISSION_ID")
	private ScAdmission admission;

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

	public Date getExptdateOfPayment() {
		return exptdateOfPayment;
	}

	public void setExptdateOfPayment(Date exptdateOfPayment) {
		this.exptdateOfPayment = exptdateOfPayment;
	}

	public Date getActdateOfPayment() {
		return actdateOfPayment;
	}

	public void setActdateOfPayment(Date actdateOfPayment) {
		this.actdateOfPayment = actdateOfPayment;
	}

	public String getMonthOf() {
		return monthOf;
	}

	public void setMonthOf(String monthOf) {
		this.monthOf = monthOf;
	}

	public ScAdmission getAdmission() {
		return admission;
	}

	public void setAdmission(ScAdmission admission) {
		this.admission = admission;
	}
}
