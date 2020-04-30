package com.yourschool.server.entity.student;

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
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.yourschool.server.entity.employee.ScRecordAudit;

@Entity
@Table(name = "SC_STUDENT_ATTENDENCE")
public class ScStudentAttendence implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "SC_ID")
	private Long id;

	@Column(name = "standard")
	private String standard;

	@Column(name = "att_date")
	private Date attDate;

	@Embedded
	private ScRecordAudit recordAudit = new ScRecordAudit();

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "SC_STUDENT_ATTENDENCE_REF", joinColumns = {
			@JoinColumn(name = "STUDENT_ATTD_ID", referencedColumnName = "SC_ID") }, inverseJoinColumns = {
					@JoinColumn(name = "STUDENT_ID", referencedColumnName = "SC_ID") })
	@Fetch(value = FetchMode.SUBSELECT)
	private List<ScStudent> students = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public Date getAttDate() {
		return attDate;
	}

	public void setAttDate(Date attDate) {
		this.attDate = attDate;
	}

	public List<ScStudent> getStudents() {
		return students;
	}

	public void setStudents(List<ScStudent> students) {
		this.students = students;
	}

	public ScRecordAudit getRecordAudit() {
		return recordAudit;
	}

	public void setRecordAudit(ScRecordAudit recordAudit) {
		this.recordAudit = recordAudit;
	}

}
