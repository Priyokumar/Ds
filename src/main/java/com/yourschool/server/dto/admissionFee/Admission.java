package com.yourschool.server.dto.admissionFee;

import java.util.ArrayList;
import java.util.List;

import com.yourschool.server.dto.employee.RecordAudit;

public class Admission {

	private Long id;

	private String admissionRefNo;
	
	private String status;

	private String academicYear;

	private String admissionDate;

	private String standard;

	private Double admissionAmount;

	private Double paidAmount;

	private Double dueAmount;

	private String promiseToPayDate;

	private StudentBasicDetail student;

	private RecordAudit recordAudit;

	private List<Fee> fees = new ArrayList<>();

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

	public String getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(String admissionDate) {
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

	public String getPromiseToPayDate() {
		return promiseToPayDate;
	}

	public void setPromiseToPayDate(String promiseToPayDate) {
		this.promiseToPayDate = promiseToPayDate;
	}

	public StudentBasicDetail getStudent() {
		return student;
	}

	public void setStudent(StudentBasicDetail student) {
		this.student = student;
	}

	public List<Fee> getFees() {
		return fees;
	}

	public void setFees(List<Fee> fees) {
		this.fees = fees;
	}

	public RecordAudit getRecordAudit() {
		return recordAudit;
	}

	public void setRecordAudit(RecordAudit recordAudit) {
		this.recordAudit = recordAudit;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
