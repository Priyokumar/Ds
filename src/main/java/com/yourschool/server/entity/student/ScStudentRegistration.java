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

import com.yourschool.server.entity.employee.ScRecordAudit;

@Entity
@Table(name = "SC_STUDENT_REGISTRATION")
public class ScStudentRegistration implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "SC_ID")
	private Long id;

	@Column(name = "REGISTRATION_NO")
	private String registrationNo;

	@Column(name = "REGISTRATION_DATE")
	private Date registrationDate;

	@Column(name = "REGISTRATION_STATUS")
	private String registrationStatus;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "STUDENT_ID")
	private ScStudent student;

	@Embedded
	private ScRecordAudit recordAudit = new ScRecordAudit();

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

	public String getRegistrationStatus() {
		return registrationStatus;
	}

	public void setRegistrationStatus(String registrationStatus) {
		this.registrationStatus = registrationStatus;
	}

	public ScStudent getStudent() {
		return student;
	}

	public void setStudent(ScStudent student) {
		this.student = student;
	}

	public ScRecordAudit getRecordAudit() {
		return recordAudit;
	}

	public void setRecordAudit(ScRecordAudit recordAudit) {
		this.recordAudit = recordAudit;
	}

}
