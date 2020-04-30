package com.yourschool.server.dto.student;

import java.util.List;

import com.yourschool.server.dto.employee.RecordAudit;

public class StudentClass {

	private Long id;

	private Integer classCode;

	private String className;

	private RecordAudit recordAudit;

	private List<StudentSubject> subjects;

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

	public List<StudentSubject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<StudentSubject> subjects) {
		this.subjects = subjects;
	}

	public RecordAudit getRecordAudit() {
		return recordAudit;
	}

	public void setRecordAudit(RecordAudit recordAudit) {
		this.recordAudit = recordAudit;
	}

}
