package com.yourschool.server.dto.student;


public class StudentSubject {

	private Long id;

	private String subjectCode;

	private String subjectName;

	private StudentClass standard;

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

	public StudentClass getStandard() {
		return standard;
	}

	public void setStandard(StudentClass standard) {
		this.standard = standard;
	}

}
