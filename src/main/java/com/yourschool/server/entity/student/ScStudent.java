package com.yourschool.server.entity.student;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.yourschool.server.entity.ScDocument;
import com.yourschool.server.entity.employee.ScAddress;
import com.yourschool.server.entity.employee.ScRecordAudit;

@Entity
@Table(name = "SC_STUDENT")
public class ScStudent implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "SC_ID")
	private Long id;

	@Column(name = "REGISTRATION_NO")
	private String registrationNo;

	@Column(name = "REGISTRATION_DATE")
	private Date registrationDate;
	
	@Column(name = "status")
	private String status;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "MIDDLE_NAME")
	private String middleName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "STANDARD")
	private String standard;

	@Column(name = "ROLL_NO")
	private Integer rollNo;

	@Column(name = "DOB")
	private Date dob;

	@Column(name = "JOINING_DATE")
	private Date joiningDate;
	
	@Column(name = "GENDER")
	private String gender;
	
	@Column(name = "BLOOD_GROUP")
	private String bloodGroup;
	
	@Column(name = "RELIGION")
	private String religion;
	
	@Column(name = "COMMUNITY")
	private String community;
	
	@Column(name = "NATIONALITY")
	private String nationality;
	
	@Column(name = "AADHAAR_NO")
	private String aadhaarNo;
	
	@Column(name = "PHYSICALLY_CHALLENGED")
	private Boolean physicallyChallenged;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "PROFILE_PIC")
	private ScDocument profilePic;

	@Embedded
	private ScRecordAudit recordAudit = new ScRecordAudit();
	
	@Column(name = "SAME_AS_PERM_ADDR")
	private Boolean sameAsPermAddr;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "CORRESPONDENT_ADDRESS_ID")
	private ScAddress correspondentAddress;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "PERMANENT_ADDRESS_ID")
	private ScAddress permanentAddress;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "FATHER_INFO_ID")
	private ScStudentGuardian fatherInfo;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "MOTHER_INFO_ID")
	private ScStudentGuardian motherInfo;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "GUARDIAN_INFO_ID")
	private ScStudentGuardian guardianInfo;

	public ScStudentGuardian getFatherInfo() {
		return fatherInfo;
	}

	public void setFatherInfo(ScStudentGuardian fatherInfo) {
		this.fatherInfo = fatherInfo;
	}

	public ScStudentGuardian getMotherInfo() {
		return motherInfo;
	}

	public void setMotherInfo(ScStudentGuardian motherInfo) {
		this.motherInfo = motherInfo;
	}

	public ScStudentGuardian getGuardianInfo() {
		return guardianInfo;
	}

	public void setGuardianInfo(ScStudentGuardian guardianInfo) {
		this.guardianInfo = guardianInfo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
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

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public Integer getRollNo() {
		return rollNo;
	}

	public void setRollNo(Integer rollNo) {
		this.rollNo = rollNo;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Long getAge() {

		return null;

	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
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

	public ScRecordAudit getRecordAudit() {
		return recordAudit;
	}

	public void setRecordAudit(ScRecordAudit recordAudit) {
		this.recordAudit = recordAudit;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getCommunity() {
		return community;
	}

	public void setCommunity(String community) {
		this.community = community;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getAadhaarNo() {
		return aadhaarNo;
	}

	public void setAadhaarNo(String aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
	}

	public Boolean getPhysicallyChallenged() {
		return physicallyChallenged;
	}

	public void setPhysicallyChallenged(Boolean physicallyChallenged) {
		this.physicallyChallenged = physicallyChallenged;
	}

	public Boolean getSameAsPermAddr() {
		return sameAsPermAddr;
	}

	public void setSameAsPermAddr(Boolean sameAsPermAddr) {
		this.sameAsPermAddr = sameAsPermAddr;
	}

	public ScDocument getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(ScDocument profilePic) {
		this.profilePic = profilePic;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
