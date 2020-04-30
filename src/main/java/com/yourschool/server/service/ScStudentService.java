package com.yourschool.server.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourschool.server.dto.ActionResponse;
import com.yourschool.server.dto.ApiUtil;
import com.yourschool.server.dto.Document;
import com.yourschool.server.dto.employee.Address;
import com.yourschool.server.dto.error.NotFoundException;
import com.yourschool.server.dto.student.Student;
import com.yourschool.server.dto.student.StudentGuardian;
import com.yourschool.server.dto.student.StudentResponse;
import com.yourschool.server.dto.student.StudentsResponse;
import com.yourschool.server.entity.ScDocument;
import com.yourschool.server.entity.employee.ScAddress;
import com.yourschool.server.entity.student.ScStudent;
import com.yourschool.server.entity.student.ScStudentGuardian;
import com.yourschool.server.service.common.CommonService;
import com.yourschool.server.util.ScDateUtil;
import com.yourschool.server.util.ScUtil;
import com.yourschool.server.vo.FieldType;
import com.yourschool.server.vo.Filter;
import com.yourschool.server.vo.Operator;
import com.yourschool.server.vo.StudentStatus;

@Service
public class ScStudentService {

	@Autowired
	private CommonService commonService;

	public StudentsResponse findAllStudents(Map<String, String> allParams) {

		List<Filter> filters = null;
		if (allParams != null && !allParams.isEmpty()) {

			filters = new ArrayList<Filter>();

			for (Entry<String, String> entry : allParams.entrySet()) {
				String key = entry.getKey();
				String value = entry.getValue();
				filters.add(new Filter(key, Operator.EQUAL, FieldType.STRING, value));
			}
		}

		StudentsResponse res = new StudentsResponse();

		List<ScStudent> students = null;
		if (!ScUtil.isAllPresent(filters))
			students = commonService.findAll(ScStudent.class);
		else
			students = commonService.find(filters, ScStudent.class);

		List<Student> dtoStudents = new ArrayList<>();
		students.forEach(student -> {
			dtoStudents.add(setStudentToDto(student));
		});

		res.setApiMessage(ApiUtil.okMessage("Success"));
		res.setData(dtoStudents);
		return res;
	}

	public StudentsResponse findStudentsByStandard(String standard) {

		StudentsResponse res = new StudentsResponse();

		List<Filter> filters = Arrays.asList(new Filter("standard", Operator.EQUAL, FieldType.STRING, standard));
		List<ScStudent> students = commonService.find(filters, ScStudent.class);

		List<Student> dtoStudents = new ArrayList<>();
		students.forEach(student -> {
			dtoStudents.add(setStudentToDto(student));
		});

		res.setApiMessage(ApiUtil.okMessage("Success"));
		res.setData(dtoStudents);
		return res;
	}

	public StudentResponse findStudent(Long id) {

		StudentResponse res = new StudentResponse();
		ScStudent student = commonService.findById(id, ScStudent.class);

		if (!ScUtil.isAllPresent(student))
			throw new NotFoundException("No Student can be found !");

		Student studentDto = setStudentToDto(student);

		res.setApiMessage(ApiUtil.okMessage("Success"));
		res.setData(studentDto);

		return res;
	}

	public ActionResponse createOrUpdateStudent(Student dtoStudent, Long id) {

		ActionResponse res = new ActionResponse();

		ScStudent student = setDtoToStudent(dtoStudent, id);

		commonService.save(student);

		String message = "";
		if (ScUtil.isAllPresent(id)) {
			message = "Successfully updated.";
			res.setApiMessage(ApiUtil.okMessage(message));
		} else {
			message = "Successfully registered.";
			res.setApiMessage(ApiUtil.createdMessage(message));
			res.setActionMessage(message);
		}

		return res;
	}

	public ActionResponse deleteStudent(Long id) {

		ActionResponse res = new ActionResponse();

		ScStudent student = commonService.findById(id, ScStudent.class);

		if (!ScUtil.isAllPresent(student))
			throw new NotFoundException("No student can be found !");

		commonService.delete(student);

		res.setActionMessage("Student has been deleted successfully");
		res.setApiMessage(ApiUtil.okMessage("Student has been deleted successfully"));
		return res;
	}

	public Student setStudentToDto(ScStudent student) {

		Student studentDto = new Student();

		studentDto.setRegistrationDate(ScDateUtil.dateToString(student.getRegistrationDate()));
		studentDto.setRegistrationNo(student.getRegistrationNo());
		studentDto.setStatus(student.getStatus());
		studentDto.setAge(student.getAge());
		studentDto.setDob(ScDateUtil.dateToString(student.getDob()));
		studentDto.setFirstName(student.getFirstName());
		studentDto.setId(student.getId());
		studentDto.setJoiningDate(ScDateUtil.dateToString(student.getJoiningDate()));
		studentDto.setLastName(student.getLastName());
		studentDto.setMiddleName(student.getMiddleName());
		studentDto.setRollNo(student.getRollNo());
		studentDto.setStandard(student.getStandard());
		studentDto.setBloodGroup(student.getBloodGroup());
		studentDto.setCommunity(student.getCommunity());
		studentDto.setGender(student.getGender());
		studentDto.setNationality(student.getNationality());
		studentDto.setPhysicallyChallenged(student.getPhysicallyChallenged());
		studentDto.setReligion(student.getReligion());
		studentDto.setSameAsPermAddr(student.getSameAsPermAddr());
		studentDto.setProfilePic(setDocDtoDoc(student.getProfilePic()));

		ScAddress permanentAddress = student.getPermanentAddress();
		if (ScUtil.isAllPresent(permanentAddress)) {
			Address permAddDto = new Address();
			permAddDto.setCountry(permanentAddress.getCountry());
			permAddDto.setDistrict(permanentAddress.getDistrict());
			permAddDto.setFirstLine(permanentAddress.getFirstLine());
			permAddDto.setId(permanentAddress.getId());
			permAddDto.setSecondLine(permanentAddress.getSecondLine());
			permAddDto.setState(permanentAddress.getState());
			studentDto.setPermanentAddress(permAddDto);
		}

		ScAddress correspondentAddress = student.getCorrespondentAddress();
		if (ScUtil.isAllPresent(correspondentAddress)) {
			Address corrAddrDto = new Address();
			corrAddrDto.setCountry(correspondentAddress.getCountry());
			corrAddrDto.setDistrict(correspondentAddress.getDistrict());
			corrAddrDto.setFirstLine(correspondentAddress.getFirstLine());
			corrAddrDto.setId(correspondentAddress.getId());
			corrAddrDto.setSecondLine(correspondentAddress.getSecondLine());
			corrAddrDto.setState(correspondentAddress.getState());
			studentDto.setCorrespondentAddress(corrAddrDto);
		}

		ScStudentGuardian fatherInfo = student.getFatherInfo();
		if (ScUtil.isAllPresent(fatherInfo)) {
			StudentGuardian fatherDto = new StudentGuardian();
			fatherDto.setContactNo(fatherInfo.getContactNo());
			fatherDto.setDob(ScDateUtil.dateToString(fatherInfo.getDob()));
			fatherDto.setId(fatherInfo.getId());
			fatherDto.setName(fatherInfo.getName());
			fatherDto.setEduQualification(fatherInfo.getEduQualification());
			fatherDto.setOccupation(fatherInfo.getOccupation());
			fatherDto.setIncome(fatherInfo.getIncome());
			studentDto.setFatherInfo(fatherDto);

		}

		ScStudentGuardian motherInfo = student.getMotherInfo();
		if (ScUtil.isAllPresent(motherInfo)) {
			StudentGuardian motherInfoDto = new StudentGuardian();
			motherInfoDto.setContactNo(motherInfo.getContactNo());
			motherInfoDto.setDob(ScDateUtil.dateToString(motherInfo.getDob()));
			motherInfoDto.setId(motherInfo.getId());
			motherInfoDto.setName(fatherInfo.getName());
			motherInfoDto.setEduQualification(motherInfo.getEduQualification());
			motherInfoDto.setOccupation(motherInfo.getOccupation());
			motherInfoDto.setIncome(motherInfo.getIncome());
			studentDto.setMotherInfo(motherInfoDto);
		}

		ScStudentGuardian guardianInfo = student.getGuardianInfo();
		if (ScUtil.isAllPresent(guardianInfo)) {
			StudentGuardian guardianInfoDto = new StudentGuardian();
			guardianInfoDto.setContactNo(guardianInfo.getContactNo());
			guardianInfoDto.setDob(ScDateUtil.dateToString(guardianInfo.getDob()));
			guardianInfoDto.setId(guardianInfo.getId());
			guardianInfoDto.setName(guardianInfo.getName());
			guardianInfoDto.setEduQualification(guardianInfo.getEduQualification());
			guardianInfoDto.setOccupation(guardianInfo.getOccupation());
			guardianInfoDto.setIncome(guardianInfo.getIncome());
			studentDto.setGuardianInfo(guardianInfoDto);
		}

		return studentDto;
	}

	public ScStudent setDtoToStudent(Student studentDto, Long id) {

		ScStudent student = new ScStudent();

		if (ScUtil.isAllPresent(id))
			student = commonService.findById(id, ScStudent.class);

		if (!ScUtil.isAllPresent(student))
			throw new NotFoundException("No student can be found !");

		if (!ScUtil.isAllPresent(student.getId())) {
			student.setRegistrationNo(ScUtil.getGeneratedNumber("REG"));
			student.setRegistrationDate(new Date());
			student.setStatus(StudentStatus.ACTIVE);
		} else {
			student.setStatus(studentDto.getStatus());
		}

		student.setDob(ScDateUtil.stringToDate(studentDto.getDob()));
		student.setFirstName(studentDto.getFirstName());
		student.setId(studentDto.getId());
		student.setJoiningDate(ScDateUtil.stringToDate(studentDto.getJoiningDate()));
		student.setLastName(studentDto.getLastName());
		student.setMiddleName(studentDto.getMiddleName());
		student.setRollNo(studentDto.getRollNo());
		student.setStandard(studentDto.getStandard());
		student.setReligion(studentDto.getReligion());

		student.setBloodGroup(studentDto.getBloodGroup());
		student.setCommunity(studentDto.getCommunity());
		student.setGender(studentDto.getGender());
		student.setNationality(studentDto.getNationality());
		student.setPhysicallyChallenged(studentDto.getPhysicallyChallenged());

		student.setSameAsPermAddr(studentDto.getSameAsPermAddr());

		if (student.getSameAsPermAddr() == true) {
			if (ScUtil.isAllPresent(student.getPermanentAddress())) {
				student.setPermanentAddress(null);
			}
		}

		Address permAddDto = studentDto.getPermanentAddress();
		if (ScUtil.isAllPresent(permAddDto) && studentDto.getSameAsPermAddr() == false) {
			if (ScUtil.isAllPresent(permAddDto)) {

				ScAddress permanentAddress = new ScAddress();
				if (ScUtil.isAllPresent(student.getPermanentAddress()))
					permanentAddress = student.getPermanentAddress();
				permanentAddress.setCountry(permAddDto.getCountry());
				permanentAddress.setDistrict(permAddDto.getDistrict());
				permanentAddress.setFirstLine(permAddDto.getFirstLine());
				// permanentAddress.setId(permAddDto.getId());
				permanentAddress.setSecondLine(permAddDto.getSecondLine());
				permanentAddress.setState(permAddDto.getState());

				if (!ScUtil.isAllPresent(student.getPermanentAddress()))
					student.setPermanentAddress(permanentAddress);
			}
		}

		Address corrAddrDto = studentDto.getCorrespondentAddress();
		if (ScUtil.isAllPresent(corrAddrDto)) {

			ScAddress correspondentAddress = new ScAddress();
			if (ScUtil.isAllPresent(student.getCorrespondentAddress()))
				correspondentAddress = student.getCorrespondentAddress();
			correspondentAddress.setCountry(corrAddrDto.getCountry());
			correspondentAddress.setDistrict(corrAddrDto.getDistrict());
			correspondentAddress.setFirstLine(corrAddrDto.getFirstLine());
			// correspondentAddress.setId(corrAddrDto.getId());
			correspondentAddress.setSecondLine(corrAddrDto.getSecondLine());
			correspondentAddress.setState(corrAddrDto.getState());

			if (!ScUtil.isAllPresent(student.getCorrespondentAddress()))
				student.setCorrespondentAddress(correspondentAddress);
		}

		StudentGuardian fatherInfoDto = studentDto.getFatherInfo();
		if (ScUtil.isAllPresent(fatherInfoDto)) {

			ScStudentGuardian guardian = new ScStudentGuardian();
			if (ScUtil.isAllPresent(student.getFatherInfo()))
				guardian = student.getFatherInfo();
			guardian.setContactNo(fatherInfoDto.getContactNo());
			guardian.setDob(ScDateUtil.stringToDate(fatherInfoDto.getDob()));
			// guardian.setId(fatherInfoDto.getId());
			guardian.setName(fatherInfoDto.getName());
			guardian.setEduQualification(fatherInfoDto.getEduQualification());
			guardian.setOccupation(fatherInfoDto.getOccupation());
			guardian.setIncome(fatherInfoDto.getIncome());

			if (!ScUtil.isAllPresent(student.getFatherInfo()))
				student.setFatherInfo(guardian);
		}

		StudentGuardian motherInfoDto = studentDto.getMotherInfo();
		if (ScUtil.isAllPresent(motherInfoDto)) {

			ScStudentGuardian guardian = new ScStudentGuardian();
			if (ScUtil.isAllPresent(student.getMotherInfo()))
				guardian = student.getMotherInfo();
			guardian.setContactNo(motherInfoDto.getContactNo());
			guardian.setDob(ScDateUtil.stringToDate(motherInfoDto.getDob()));
			// guardian.setId(motherInfoDto.getId());
			guardian.setName(motherInfoDto.getName());
			guardian.setEduQualification(motherInfoDto.getEduQualification());
			guardian.setOccupation(motherInfoDto.getOccupation());
			guardian.setIncome(motherInfoDto.getIncome());

			if (!ScUtil.isAllPresent(student.getMotherInfo()))
				student.setMotherInfo(guardian);
		}

		StudentGuardian guardianInfoDto = studentDto.getGuardianInfo();
		if (ScUtil.isAllPresent(guardianInfoDto)) {

			ScStudentGuardian guardian = new ScStudentGuardian();
			if (ScUtil.isAllPresent(student.getGuardianInfo()))
				guardian = student.getGuardianInfo();
			guardian.setContactNo(guardianInfoDto.getContactNo());
			guardian.setDob(ScDateUtil.stringToDate(guardianInfoDto.getDob()));
			// guardian.setId(guardianInfoDto.getId());
			guardian.setName(guardianInfoDto.getName());
			guardian.setEduQualification(guardianInfoDto.getEduQualification());
			guardian.setOccupation(guardianInfoDto.getOccupation());
			guardian.setIncome(guardianInfoDto.getIncome());

			if (!ScUtil.isAllPresent(student.getGuardianInfo()))
				student.setGuardianInfo(guardian);
		}

		return student;
	}

	private Document setDocDtoDoc(ScDocument scDoc) {
		if (ScUtil.isAllPresent(scDoc)) {
			Document doc = new Document();
			doc.setId(scDoc.getId());
			String docUrl = "/document/" + doc.getId() + "/view";
			doc.setDocUrl(docUrl);
			return doc;
		}
		return null;
	}

}
