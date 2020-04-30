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
@Table(name = "SC_EXPENSE")
public class ScExpense implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "SC_ID")
	private Long id;

	@Column(name = "REF_NO")
	private String refNo;

	@Column(name = "AMOUNT")
	private Double amount;

	@Column(name = "EXPENSE_TYPE")
	private String expenseType;

	@Column(name = "EXPENSE_DETAILS")
	private String expenseDetails;

	@Column(name = "COMMENTS")
	private String comments;

	@Column(name = "EXPENSE_DATE")
	private Date expenseDate;

	@Embedded
	private ScRecordAudit recordAudit;

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

	public ScRecordAudit getRecordAudit() {
		return recordAudit;
	}

	public void setRecordAudit(ScRecordAudit recordAudit) {
		this.recordAudit = recordAudit;
	}

	public Date getExpenseDate() {
		return expenseDate;
	}

	public void setExpenseDate(Date expenseDate) {
		this.expenseDate = expenseDate;
	}

}
