package com.yourschool.server.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourschool.server.dto.ActionResponse;
import com.yourschool.server.dto.ApiUtil;
import com.yourschool.server.dto.error.NotFoundException;
import com.yourschool.server.dto.student.StudentClass;
import com.yourschool.server.dto.student.StudentClassResponse;
import com.yourschool.server.dto.student.StudentClassesReponse;
import com.yourschool.server.dto.student.StudentSubject;
import com.yourschool.server.entity.student.ScStudentClass;
import com.yourschool.server.entity.student.ScStudentSubject;
import com.yourschool.server.service.common.CommonService;
import com.yourschool.server.util.ScUtil;

@Service
public class ScStudentClassService {

	@Autowired
	private CommonService commonService;

	public StudentClassesReponse findAllStudentClass() {

		StudentClassesReponse res = new StudentClassesReponse();

		List<ScStudentClass> studentClasses = commonService.findAll(ScStudentClass.class);
		if (!ScUtil.isAllPresent(studentClasses))
			throw new NotFoundException("No studentClass can be found !");

		List<StudentClass> dtoStudentClasses = setClassesToDto(studentClasses);

		res.setApiMessage(ApiUtil.okMessage("Success"));
		res.setData(dtoStudentClasses);
		return res;
	}

	public StudentClassResponse findStudentClass(Long id) {

		StudentClassResponse res = new StudentClassResponse();

		ScStudentClass studentClass = commonService.findById(id, ScStudentClass.class);

		if (!ScUtil.isAllPresent(studentClass))
			throw new NotFoundException("No income can be found !");

		StudentClass dtoStudentClass = setStudentClassToDto(studentClass);
		res.setApiMessage(ApiUtil.okMessage("Success"));
		res.setData(dtoStudentClass);

		return res;
	}

	public ActionResponse createOrUpdateStudentClass(StudentClass dtoStudentClass, Long id) {

		ActionResponse res = new ActionResponse();

		ScStudentClass studentClass = setDtoToStudentClass(dtoStudentClass, id);

		commonService.save(studentClass);

		String message = "";
		if (ScUtil.isAllPresent(id)) {
			message = "Successfully updated student class data";
			res.setApiMessage(ApiUtil.okMessage(message));
		} else {
			message = "Successfully created an student class";
			res.setApiMessage(ApiUtil.createdMessage(message));
			res.setActionMessage(message);
		}

		return res;
	}

	private ScStudentClass setDtoToStudentClass(StudentClass dtoStudentClass, Long id) {

		ScStudentClass studentClass = new ScStudentClass();

		studentClass.setClassCode(dtoStudentClass.getClassCode());
		studentClass.setClassName(dtoStudentClass.getClassName());
		studentClass.setId(dtoStudentClass.getId());
		studentClass.setRecordAudit(ScUtil.recordAudit(null, id)); // TODO
		studentClass.setSubjects(setDtoStudentSubjects(dtoStudentClass.getSubjects(), studentClass));

		return studentClass;
	}

	private List<ScStudentSubject> setDtoStudentSubjects(List<StudentSubject> dtoStudentSubjects,
			ScStudentClass studentClass) {

		if (!ScUtil.isAllPresent(dtoStudentSubjects))
			return null;

		List<ScStudentSubject> studentSubjects = new ArrayList<>();

		dtoStudentSubjects.forEach(dtoStudentSubject -> {

			if (!ScUtil.isAllPresent(dtoStudentSubject.getId())) {

				ScStudentSubject studentSubject = new ScStudentSubject();

				studentSubject.setId(dtoStudentSubject.getId());
				studentSubject.setStandard(studentClass);
				studentSubject.setSubjectCode(dtoStudentSubject.getSubjectCode());
				studentSubject.setSubjectName(dtoStudentSubject.getSubjectName());

				studentSubjects.add(studentSubject);
			}
		});
		return studentSubjects;
	}

	public ActionResponse deleteStudentClass(Long id) {

		ActionResponse res = new ActionResponse();

		ScStudentClass studentClass = commonService.findById(id, ScStudentClass.class);

		if (!ScUtil.isAllPresent(studentClass))
			throw new NotFoundException("No student class can be found !");

		commonService.delete(studentClass);

		res.setActionMessage("Student class has been deleted successfully");
		res.setApiMessage(ApiUtil.okMessage("Student class has been deleted successfully"));
		return res;
	}

	public List<StudentClass> setClassesToDto(List<ScStudentClass> studentClasses) {

		if (ScUtil.isAllPresent(studentClasses))
			return null;

		List<StudentClass> dtoStudentClasses = new ArrayList<>();

		studentClasses.forEach(studentClass -> {
			StudentClass dtoStudentClass = setStudentClassToDto(studentClass);
			dtoStudentClasses.add(dtoStudentClass);
		});
		return dtoStudentClasses;
	}

	public StudentClass setStudentClassToDto(ScStudentClass studentClass) {

		StudentClass dtoStudentClass = new StudentClass();

		dtoStudentClass.setClassCode(studentClass.getClassCode());
		dtoStudentClass.setClassName(studentClass.getClassName());
		dtoStudentClass.setId(studentClass.getId());
		dtoStudentClass.setRecordAudit(ScUtil.recordAuditToDto(studentClass.getRecordAudit()));

		List<StudentSubject> studentSubjects = setStudentSubjectsToDto(studentClass.getSubjects());
		dtoStudentClass.setSubjects(studentSubjects);

		return dtoStudentClass;
	}

	public List<StudentSubject> setStudentSubjectsToDto(List<ScStudentSubject> studentSubjects) {

		if (!ScUtil.isAllPresent(studentSubjects))
			return null;

		List<StudentSubject> dtoStudentSubjects = new ArrayList<>();

		studentSubjects.forEach(studentSubject -> {
			StudentSubject dtoStudentSubject = setStudentSubjectToDto(studentSubject);
			dtoStudentSubjects.add(dtoStudentSubject);
		});
		return dtoStudentSubjects;
	}

	public StudentSubject setStudentSubjectToDto(ScStudentSubject studentSubject) {

		if (!ScUtil.isAllPresent(studentSubject))
			return null;

		StudentSubject dtoStudentSubject = new StudentSubject();

		dtoStudentSubject.setId(studentSubject.getId());
		dtoStudentSubject.setSubjectCode(studentSubject.getSubjectCode());
		dtoStudentSubject.setSubjectName(studentSubject.getSubjectName());

		return dtoStudentSubject;
	}
}
