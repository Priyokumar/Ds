package com.yourschool.server.dto.employee;

import com.yourschool.server.dto.Document;

public class Employee {

	private Long id;
	
	private String empCode;

	private String firstName;

	private String middleName;

	private String lastName;

	private String gender;

	private String email;

	private String mobileNo;

	private String status;

	private String dob;

	private String joiningDate;

	private String employeeType;

	private String designation;

	private Boolean sameAsPermanentAddress = false;

	private Document profilePic;

	private Address correspondentAddress;

	private Address permanentAddress;

	private PersonalInfo personalInfo;

	private RecordAudit recordAudit;

	private EmployeeHistory lastEmployeeHistory;

	private AcademicBackground highestQualification;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public Boolean getSameAsPermanentAddress() {
		return sameAsPermanentAddress;
	}

	public void setSameAsPermanentAddress(Boolean sameAsPermanentAddress) {
		this.sameAsPermanentAddress = sameAsPermanentAddress;
	}

	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Address getCorrespondentAddress() {
		return correspondentAddress;
	}

	public void setCorrespondentAddress(Address correspondentAddress) {
		this.correspondentAddress = correspondentAddress;
	}

	public Address getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(Address permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public PersonalInfo getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(PersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}

	public EmployeeHistory getLastEmployeeHistory() {
		return lastEmployeeHistory;
	}

	public void setLastEmployeeHistory(EmployeeHistory lastEmployeeHistory) {
		this.lastEmployeeHistory = lastEmployeeHistory;
	}

	public AcademicBackground getHighestQualification() {
		return highestQualification;
	}

	public void setHighestQualification(AcademicBackground highestQualification) {
		this.highestQualification = highestQualification;
	}

	public RecordAudit getRecordAudit() {
		return recordAudit;
	}

	public void setRecordAudit(RecordAudit recordAudit) {
		this.recordAudit = recordAudit;
	}

	public Document getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(Document profilePic) {
		this.profilePic = profilePic;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	
	

}
