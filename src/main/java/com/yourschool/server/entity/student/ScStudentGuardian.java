package com.yourschool.server.entity.student;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SC_STUDENT_GUARDIAN")
public class ScStudentGuardian implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "SC_ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DOB")
	private Date dob;

	@Column(name = "EDU_QUALIFICATION")
	private String eduQualification;

	@Column(name = "CONTACT_NO")
	private String contactNo;
	
	@Column(name = "OCCUPATION")
	private String occupation;
	
	@Column(name = "INCOME")
	private Double income;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
	

	public String getEduQualification() {
		return eduQualification;
	}

	public void setEduQualification(String eduQualification) {
		this.eduQualification = eduQualification;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}
	
	

}
