package com.yourschool.server.entity.admissionfee;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.yourschool.server.entity.employee.ScRecordAudit;
import com.yourschool.server.entity.student.ScStudent;

@Entity
@Table(name = "SC_ADMISSION")
public class ScAdmission implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "SC_ID")
	private Long id;

	@Column(name = "ADMISSION_REF_NO")
	private String admissionRefNo;
	
	@Column(name = "status")
	private String status;

	@Column(name = "ACADEMIC_YEAR")
	private String academicYear;

	@Column(name = "ADMISSION_DATE")
	private Date admissionDate;

	@Column(name = "STANDARD")
	private String standard;

	@Column(name = "ADMISSION_AMOUNT")
	private Double admissionAmount;

	@Column(name = "PAID_AMOUNT")
	private Double paidAmount;

	@Column(name = "DUE_AMOUNT")
	private Double dueAmount;

	@Column(name = "PROMISE_TO_PAY_DATE")
	private Date promiseToPayDate;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "STUDENT_ID")
	private ScStudent student;

	@Embedded
	private ScRecordAudit recordAudit = new ScRecordAudit();

	@OneToMany(targetEntity = ScFee.class, cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "ADMISSION_ID", referencedColumnName = "SC_ID")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<ScFee> fees = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAdmissionRefNo() {
		return admissionRefNo;
	}

	public void setAdmissionRefNo(String admissionRefNo) {
		this.admissionRefNo = admissionRefNo;
	}

	public String getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}

	public Date getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public Double getAdmissionAmount() {
		return admissionAmount;
	}

	public void setAdmissionAmount(Double admissionAmount) {
		this.admissionAmount = admissionAmount;
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

	public Date getPromiseToPayDate() {
		return promiseToPayDate;
	}

	public void setPromiseToPayDate(Date promiseToPayDate) {
		this.promiseToPayDate = promiseToPayDate;
	}

	public ScStudent getStudent() {
		return student;
	}

	public void setStudent(ScStudent student) {
		this.student = student;
	}

	public List<ScFee> getFees() {
		return fees;
	}

	public void setFees(List<ScFee> fees) {
		this.fees = fees;
	}

	public ScRecordAudit getRecordAudit() {
		return recordAudit;
	}

	public void setRecordAudit(ScRecordAudit recordAudit) {
		this.recordAudit = recordAudit;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
