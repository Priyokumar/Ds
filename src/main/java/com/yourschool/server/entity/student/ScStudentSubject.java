package com.yourschool.server.entity.student;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SC_SUBJECT")
public class ScStudentSubject implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "SC_ID")
	private Long id;

	@Column(name = "SUBJECT_CODE")
	private String subjectCode;

	@Column(name = "SUBJECT_NAME")
	private String subjectName;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CLASS_ID")
	private ScStudentClass standard;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public ScStudentClass getStandard() {
		return standard;
	}

	public void setStandard(ScStudentClass standard) {
		this.standard = standard;
	}

}
