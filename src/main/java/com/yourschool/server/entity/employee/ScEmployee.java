package com.yourschool.server.entity.employee;

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
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.yourschool.server.entity.ScDocument;

/**
 * @author singh-n
 *
 */
@Entity
@Table(name = "SC_EMPLOYEE")
public class ScEmployee implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SC_ID")
	private Long id;
	
	@Column(name = "EMP_CODE")
	private String empCode;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "MIDDLE_NAME")
	private String middleName;

	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "GENDER")
	private String gender;

	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "MOBILE_NO")
	private String mobileNo;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "DOB")
	private Date dob;

	@Column(name = "JOINING_DATE")
	private Date joiningDate;

	@Column(name = "EMPLOYEE_TYPE")
	private String employeeType;

	@Column(name = "DESIGNATION")
	private String designation;
	
	@Column(name = "SAMEASPERMANENT_ADDRESS")
	private Boolean sameAsPermanentAddress = false;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "PROFILE_PIC")
	private ScDocument profilePic;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "CORRESPONDENT_ADDRESS")
	private ScAddress correspondentAddress;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "PERMANENT_ADDRESS")
	private ScAddress permanentAddress;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "personalInfoEmployee", orphanRemoval = true)
	@PrimaryKeyJoinColumn
	private ScPersonalInfo personalInfo = new ScPersonalInfo();

	@Embedded
	private ScRecordAudit recordAudit = new ScRecordAudit();  

	@OneToOne(mappedBy = "lastEmployeeHistoryEmployee", cascade = CascadeType.ALL, orphanRemoval = true)
	@PrimaryKeyJoinColumn
	private ScEmployeeHistory lastEmployeeHistory = new ScEmployeeHistory();

	@OneToOne(mappedBy = "highestQualificationEmployee", cascade = CascadeType.ALL, orphanRemoval = true)
	@PrimaryKeyJoinColumn
	private ScAcademicBackground highestQualification = new ScAcademicBackground();

	@OneToMany(targetEntity = ScDocumentDetails.class, cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "SC_ID")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<ScDocumentDetails> documents = new ArrayList<>();

	@ManyToOne
	@JoinTable(name = "SC_EMPLOYEE_ATTENDENCE_REF", joinColumns = {
			@JoinColumn(name = "EMPLOYEE_ID", insertable = false, updatable = false, referencedColumnName = "SC_ID") }, inverseJoinColumns = {
					@JoinColumn(name = "EMPLOYEE_ATTD_ID", insertable = false, updatable = false, referencedColumnName = "SC_ID") })
	private ScEmployee employee;

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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
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
	
	public Boolean getSameAsPermanentAddress() {
		return sameAsPermanentAddress;
	}

	public void setSameAsPermanentAddress(Boolean sameAsPermanentAddress) {
		this.sameAsPermanentAddress = sameAsPermanentAddress;
	}

	public ScAddress getCorrespondentAddress() {
		return correspondentAddress;
	}

	public void setCorrespondentAddress(ScAddress correspondentAddress) {
		this.correspondentAddress = correspondentAddress;
	}

	public ScAddress getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(ScAddress permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public ScPersonalInfo getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(ScPersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}

	public ScEmployeeHistory getLastEmployeeHistory() {
		return lastEmployeeHistory;
	}

	public void setLastEmployeeHistory(ScEmployeeHistory lastEmployeeHistory) {
		this.lastEmployeeHistory = lastEmployeeHistory;
	}

	public ScAcademicBackground getHighestQualification() {
		return highestQualification;
	}

	public void setHighestQualification(ScAcademicBackground highestQualification) {
		this.highestQualification = highestQualification;
	}

	public List<ScDocumentDetails> getDocuments() {
		return documents;
	}

	public void setDocuments(List<ScDocumentDetails> documents) {
		this.documents = documents;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ScRecordAudit getRecordAudit() {
		return recordAudit;
	}

	public void setRecordAudit(ScRecordAudit recordAudit) {
		this.recordAudit = recordAudit;
	}

	public ScDocument getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(ScDocument profilePic) {
		this.profilePic = profilePic;
	}

	public ScEmployee getEmployee() {
		return employee;
	}

	public void setEmployee(ScEmployee employee) {
		this.employee = employee;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
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
