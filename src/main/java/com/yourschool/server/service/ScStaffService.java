package com.yourschool.server.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourschool.server.dto.ActionResponse;
import com.yourschool.server.dto.ApiUtil;
import com.yourschool.server.dto.employee.Staff;
import com.yourschool.server.dto.employee.StaffResponse;
import com.yourschool.server.dto.employee.StaffsResponse;
import com.yourschool.server.dto.error.NotFoundException;
import com.yourschool.server.dto.student.StudentClass;
import com.yourschool.server.dto.student.StudentSubject;
import com.yourschool.server.entity.employee.ScEmployee;
import com.yourschool.server.entity.employee.ScStaff;
import com.yourschool.server.entity.student.ScStudentClass;
import com.yourschool.server.entity.student.ScStudentSubject;
import com.yourschool.server.service.common.CommonService;
import com.yourschool.server.util.ScUtil;

@Service
public class ScStaffService {

	@Autowired
	private CommonService commonService;

	@Autowired
	private ScEmployeeService employeeService;

	@Autowired
	private ScStudentClassService studentClassService;

	public StaffsResponse findAllStaff() {

		StaffsResponse res = new StaffsResponse();

		List<ScStaff> staffs = commonService.findAll(ScStaff.class);
		if (!ScUtil.isAllPresent(staffs))
			throw new NotFoundException("No staff can be found !");

		List<Staff> dtoStaffs = new ArrayList<>();
		staffs.forEach(staff -> {
			Staff dtoStaff = setStaffToDto(staff);
			dtoStaffs.add(dtoStaff);
		});

		res.setApiMessage(ApiUtil.okMessage("Success"));
		res.setData(dtoStaffs);
		return res;
	}

	private Staff setStaffToDto(ScStaff staff) {

		Staff dtoStaff = new Staff();

		dtoStaff.setId(staff.getId());

		if (ScUtil.isAllPresent(staff.getEmployee()))
			dtoStaff.setEmployee(employeeService.setEmployeeToDto(staff.getEmployee()));

		dtoStaff.setClassesTaken(studentClassService.setClassesToDto(staff.getClassesTaken()));
		dtoStaff.setMainTeachingSubject(studentClassService.setStudentSubjectToDto(staff.getMainTeachingSubject()));
		dtoStaff.setOtherTeachingSubjects(
				studentClassService.setStudentSubjectsToDto(staff.getOtherTeachingSubjects()));
		dtoStaff.setRecordAudit(ScUtil.recordAuditToDto(staff.getRecordAudit()));

		return dtoStaff;
	}

	public StaffResponse findStaff(Long id) {

		StaffResponse res = new StaffResponse();

		ScStaff staff = commonService.findById(id, Staff.class);

		if (!ScUtil.isAllPresent(staff))
			throw new NotFoundException("No staff can be found !");

		Staff staffDto = setStaffToDto(staff);
		res.setApiMessage(ApiUtil.okMessage("Success"));
		res.setData(staffDto);

		return res;
	}

	public ActionResponse createOrUpdateStaff(Staff dtoStaff, Long id) {

		ActionResponse res = new ActionResponse();

		ScStaff staff = setDtoToStaff(dtoStaff, id);

		commonService.save(staff);

		String message = "";
		if (ScUtil.isAllPresent(id)) {
			message = "Successfully staff data";
			res.setApiMessage(ApiUtil.okMessage(message));
		} else {
			message = "Successfully created an staff";
			res.setApiMessage(ApiUtil.createdMessage(message));
			res.setActionMessage(message);
		}

		return res;
	}

	private ScStaff setDtoToStaff(Staff dtoStaff, Long id) {

		ScStaff staff = new ScStaff();

		if (ScUtil.isAllPresent(id))
			staff = commonService.findById(id, ScStaff.class);

		if (!ScUtil.isAllPresent(staff))
			throw new NotFoundException("No staff can be found !");

		staff.setId(dtoStaff.getId());
		staff.setClassesTaken(dtoToClasses(dtoStaff.getClassesTaken()));

		if (ScUtil.isAllPresent(dtoStaff.getEmployee(), dtoStaff.getEmployee().getId()))
			staff.setEmployee(commonService.findById(dtoStaff.getEmployee().getId(), ScEmployee.class));

		if (ScUtil.isAllPresent(dtoStaff.getMainTeachingSubject(), dtoStaff.getMainTeachingSubject().getId()))
			staff.setMainTeachingSubject(
					commonService.findById(dtoStaff.getMainTeachingSubject().getId(), ScStudentSubject.class));
		staff.setOtherTeachingSubjects(setDtoStudentSubjects(dtoStaff.getOtherTeachingSubjects()));
		staff.setRecordAudit(ScUtil.recordAudit(null, id));

		return staff;
	}

	public List<ScStudentClass> dtoToClasses(List<StudentClass> dtoStudentClasses) {

		if (ScUtil.isAllPresent(dtoStudentClasses))
			return null;

		List<ScStudentClass> studentClasses = new ArrayList<>();

		dtoStudentClasses.forEach(dtoStudentClass -> {

			if (ScUtil.isAllPresent(dtoStudentClass)) {

				ScStudentClass studentClass = commonService.findById(dtoStudentClass.getId(), ScStudentClass.class);
				studentClasses.add(studentClass);
			}

		});
		return studentClasses;
	}

	private List<ScStudentSubject> setDtoStudentSubjects(List<StudentSubject> dtoStudentSubjects) {

		if (!ScUtil.isAllPresent(dtoStudentSubjects))
			return null;

		List<ScStudentSubject> studentSubjects = new ArrayList<>();

		dtoStudentSubjects.forEach(dtoStudentSubject -> {

			if (!ScUtil.isAllPresent(dtoStudentSubject.getId())) {

				ScStudentSubject studentSubject = commonService.findById(dtoStudentSubject.getId(),
						ScStudentSubject.class);
				studentSubjects.add(studentSubject);
			}
		});
		return studentSubjects;
	}

	public ActionResponse deleteStaff(Long id) {

		ActionResponse res = new ActionResponse();

		ScStaff staff = commonService.findById(id, ScStaff.class);

		if (!ScUtil.isAllPresent(staff))
			throw new NotFoundException("No staff can be found !");

		commonService.delete(staff);

		res.setActionMessage("staff has been deleted successfully");
		res.setApiMessage(ApiUtil.okMessage("staff has been deleted successfully"));
		return res;
	}

}
