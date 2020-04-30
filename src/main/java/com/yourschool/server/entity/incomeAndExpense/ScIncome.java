package com.yourschool.server.entity.incomeAndExpense;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.yourschool.server.entity.employee.ScRecordAudit;

@Entity
@Table(name = "SC_INCOME")
public class ScIncome implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "SC_ID")
	private Long id;

	@Column(name = "REF_NO")
	private String refNo;

	@Column(name = "AMOUNT")
	private Double amount;

	@Column(name = "INCOME_TYPE")
	private String incomeType;

	@Column(name = "INCOME_DETAILS")
	private String incomeDetails;

	@Column(name = "COMMENTS")
	private String comments;

	@Column(name = "INCOME_DATE")
	private Date incomeDate;

	@Embedded
	private ScRecordAudit recordAudit = new ScRecordAudit();

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

	public Date getIncomeDate() {
		return incomeDate;
	}

	public void setIncomeDate(Date incomeDate) {
		this.incomeDate = incomeDate;
	}

	public ScRecordAudit getRecordAudit() {
		return recordAudit;
	}

	public void setRecordAudit(ScRecordAudit recordAudit) {
		this.recordAudit = recordAudit;
	}

}
