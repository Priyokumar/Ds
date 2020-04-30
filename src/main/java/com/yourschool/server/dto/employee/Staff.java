package com.yourschool.server.dto.employee;

import java.util.ArrayList;
import java.util.List;

import com.yourschool.server.dto.student.StudentClass;
import com.yourschool.server.dto.student.StudentSubject;

public class Staff {

	private Long id;

	private Employee employee;

	private RecordAudit recordAudit;

	private List<StudentClass> classesTaken = new ArrayList<>();

	private List<StudentSubject> otherTeachingSubjects = new ArrayList<>();

	private StudentSubject mainTeachingSubject;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public RecordAudit getRecordAudit() {
		return recordAudit;
	}

	public void setRecordAudit(RecordAudit recordAudit) {
		this.recordAudit = recordAudit;
	}

	public List<StudentClass> getClassesTaken() {
		return classesTaken;
	}

	public void setClassesTaken(List<StudentClass> classesTaken) {
		this.classesTaken = classesTaken;
	}

	public List<StudentSubject> getOtherTeachingSubjects() {
		return otherTeachingSubjects;
	}

	public void setOtherTeachingSubjects(List<StudentSubject> otherTeachingSubjects) {
		this.otherTeachingSubjects = otherTeachingSubjects;
	}

	public StudentSubject getMainTeachingSubject() {
		return mainTeachingSubject;
	}

	public void setMainTeachingSubject(StudentSubject mainTeachingSubject) {
		this.mainTeachingSubject = mainTeachingSubject;
	}

}
