package com.yourschool.server.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourschool.server.dto.ActionResponse;
import com.yourschool.server.dto.ApiUtil;
import com.yourschool.server.dto.error.NotFoundException;
import com.yourschool.server.dto.student.Student;
import com.yourschool.server.dto.student.StudentAttendence;
import com.yourschool.server.dto.student.StudentAttendenceResponse;
import com.yourschool.server.dto.student.StudentAttendencesResponse;
import com.yourschool.server.entity.student.ScStudent;
import com.yourschool.server.entity.student.ScStudentAttendence;
import com.yourschool.server.service.common.CommonService;
import com.yourschool.server.util.ScDateUtil;
import com.yourschool.server.util.ScUtil;

@Service
public class ScStudentAttendenceService {

	@Autowired
	private CommonService commonService;

	@Autowired
	private ScStudentService studentService;

	public StudentAttendencesResponse findAllStudentAttendence() {

		StudentAttendencesResponse res = new StudentAttendencesResponse();

		List<ScStudentAttendence> studentAttendences = commonService.findAll(ScStudentAttendence.class);
		if (!ScUtil.isAllPresent(studentAttendences))
			throw new NotFoundException("No student attendence can be found !");

		List<StudentAttendence> dtoStudentAttendences = new ArrayList<>();
		studentAttendences.forEach(studentAttendence -> {
			StudentAttendence dtoStudentAttendence = setStudentAttendenceToDto(studentAttendence);
			dtoStudentAttendences.add(dtoStudentAttendence);
		});

		res.setApiMessage(ApiUtil.okMessage("Success"));
		res.setData(dtoStudentAttendences);
		return res;
	}

	private StudentAttendence setStudentAttendenceToDto(ScStudentAttendence studentAttendence) {

		StudentAttendence dtoStudentAttendence = new StudentAttendence();

		dtoStudentAttendence.setAttDate(ScDateUtil.dateToString(studentAttendence.getAttDate()));
		dtoStudentAttendence.setId(studentAttendence.getId());
		dtoStudentAttendence.setRecordAudit(ScUtil.recordAuditToDto(studentAttendence.getRecordAudit()));
		dtoStudentAttendence.setStandard(studentAttendence.getStandard());

		if (ScUtil.isAllPresent(studentAttendence.getStudents())) {

			List<Student> dtoStudents = new ArrayList<>();
			studentAttendence.getStudents().forEach(student -> {
				Student dtoStudent = studentService.setStudentToDto(student);
				dtoStudents.add(dtoStudent);
			});
			dtoStudentAttendence.setStudents(dtoStudents);
		}

		return dtoStudentAttendence;
	}

	public StudentAttendenceResponse findStudentAttendence(Long id) {

		StudentAttendenceResponse res = new StudentAttendenceResponse();

		ScStudentAttendence studentAttendence = commonService.findById(id, ScStudentAttendence.class);

		if (!ScUtil.isAllPresent(studentAttendence))
			throw new NotFoundException("No student attendence can be found !");

		StudentAttendence studentAttendenceDto = setStudentAttendenceToDto(studentAttendence);
		res.setApiMessage(ApiUtil.okMessage("Success"));
		res.setData(studentAttendenceDto);

		return res;
	}

	public ActionResponse createOrUpdateStudentAttendence(StudentAttendence dtoStudentAttendence, Long id) {

		ActionResponse res = new ActionResponse();

		ScStudentAttendence studentAttendence = setDtoToStudentAttendence(dtoStudentAttendence, id);

		commonService.save(studentAttendence);

		String message = "";
		if (ScUtil.isAllPresent(id)) {
			message = "Successfully updated the student attendence data";
			res.setApiMessage(ApiUtil.okMessage(message));
		} else {
			message = "Successfully created a student attendence";
			res.setApiMessage(ApiUtil.createdMessage(message));
			res.setActionMessage(message);
		}

		return res;
	}

	private ScStudentAttendence setDtoToStudentAttendence(StudentAttendence dtoStudentAttendence, Long id) {

		ScStudentAttendence studentAttendence = new ScStudentAttendence();

		studentAttendence.setAttDate(ScDateUtil.stringToDate(dtoStudentAttendence.getAttDate()));
		studentAttendence.setId(dtoStudentAttendence.getId());
		studentAttendence.setRecordAudit(ScUtil.recordAudit(null, id)); // TODO find user
		studentAttendence.setStandard(dtoStudentAttendence.getStandard());

		if (ScUtil.isAllPresent(dtoStudentAttendence.getStudents())) {

			List<ScStudent> students = new ArrayList<>();
			dtoStudentAttendence.getStudents().forEach(dtoStudent -> {

				if (ScUtil.isAllPresent(dtoStudent.getId())) {
					ScStudent student = commonService.findById(dtoStudent.getId(), ScStudent.class);
					students.add(student);
				}
			});
			studentAttendence.setStudents(students);
		}
		return studentAttendence;
	}

	public ActionResponse deleteStudentAttendence(Long id) {

		ActionResponse res = new ActionResponse();

		ScStudentAttendence studentAttendence = commonService.findById(id, ScStudentAttendence.class);

		if (!ScUtil.isAllPresent(studentAttendence))
			throw new NotFoundException("No student attendence can be found !");

		commonService.delete(studentAttendence);

		res.setActionMessage("Student attendence has been deleted successfully");
		res.setApiMessage(ApiUtil.okMessage("Student attendence has been deleted successfully"));
		return res;
	}

}
