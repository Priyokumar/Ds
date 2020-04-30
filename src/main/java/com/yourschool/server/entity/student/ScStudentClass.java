package com.yourschool.server.entity.student;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.yourschool.server.entity.employee.ScRecordAudit;

@Entity
@Table(name = "SC_STUDENT_CLASS")
public class ScStudentClass implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "SC_ID")
	private Long id;

	@Column(name = "CLASS_CODE")
	private Integer classCode;

	@Column(name = "CLASS_NAME")
	private String className;

	@Embedded
	private ScRecordAudit recordAudit = new ScRecordAudit();

	@OneToMany(targetEntity = ScStudentSubject.class, cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "CLASS_ID", referencedColumnName = "SC_ID")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<ScStudentSubject> subjects = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getClassCode() {
		return classCode;
	}

	public void setClassCode(Integer classCode) {
		this.classCode = classCode;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public ScRecordAudit getRecordAudit() {
		return recordAudit;
	}

	public void setRecordAudit(ScRecordAudit recordAudit) {
		this.recordAudit = recordAudit;
	}

	public List<ScStudentSubject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<ScStudentSubject> subjects) {
		this.subjects = subjects;
	}

}
