package com.yourschool.server.entity.employee;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.yourschool.server.entity.student.ScStudentClass;
import com.yourschool.server.entity.student.ScStudentSubject;

@Entity
@Table(name = "SC_STAFF")
public class ScStaff implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "SC_ID")
	private Long id;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EMPLOYEE")
	private ScEmployee employee;

	@Embedded
	private ScRecordAudit recordAudit = new ScRecordAudit();

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "SC_STAFF_CLASS_REF", joinColumns = {
			@JoinColumn(name = "STAFF_ID", referencedColumnName = "SC_ID") }, inverseJoinColumns = {
					@JoinColumn(name = "CLASS_ID", referencedColumnName = "SC_ID") })
	@Fetch(value = FetchMode.SUBSELECT)
	private List<ScStudentClass> classesTaken = new ArrayList<>();

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "SC_STAFF_SUBJECT_REF", joinColumns = {
			@JoinColumn(name = "STAFF_ID", referencedColumnName = "SC_ID") }, inverseJoinColumns = {
					@JoinColumn(name = "SUBJECT_ID", referencedColumnName = "SC_ID") })
	@Fetch(value = FetchMode.SUBSELECT)
	private List<ScStudentSubject> otherTeachingSubjects = new ArrayList<>();

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "STUDENT_ID")
	private ScStudentSubject mainTeachingSubject;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ScStudentClass> getClassesTaken() {
		return classesTaken;
	}

	public void setClassesTaken(List<ScStudentClass> classesTaken) {
		this.classesTaken = classesTaken;
	}

	public List<ScStudentSubject> getOtherTeachingSubjects() {
		return otherTeachingSubjects;
	}

	public void setOtherTeachingSubjects(List<ScStudentSubject> otherTeachingSubjects) {
		this.otherTeachingSubjects = otherTeachingSubjects;
	}

	public ScStudentSubject getMainTeachingSubject() {
		return mainTeachingSubject;
	}

	public void setMainTeachingSubject(ScStudentSubject mainTeachingSubject) {
		this.mainTeachingSubject = mainTeachingSubject;
	}

	public ScEmployee getEmployee() {
		return employee;
	}

	public void setEmployee(ScEmployee employee) {
		this.employee = employee;
	}

	public ScRecordAudit getRecordAudit() {
		return recordAudit;
	}

	public void setRecordAudit(ScRecordAudit recordAudit) {
		this.recordAudit = recordAudit;
	}

}
