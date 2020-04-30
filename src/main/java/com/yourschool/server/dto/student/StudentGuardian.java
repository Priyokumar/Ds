package com.yourschool.server.dto.student;

public class StudentGuardian {

	private Long id;

	private String name;

	private String dob;

	private String eduQualification;

	private String contactNo;

	private String occupation;

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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
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
