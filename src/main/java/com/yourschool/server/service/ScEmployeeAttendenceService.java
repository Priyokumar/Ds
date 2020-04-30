package com.yourschool.server.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourschool.server.dto.ActionResponse;
import com.yourschool.server.dto.ApiUtil;
import com.yourschool.server.dto.employee.EmployeeAttendence;
import com.yourschool.server.dto.employee.EmployeeAttendenceResponse;
import com.yourschool.server.dto.employee.EmployeeAttendencesResponse;
import com.yourschool.server.dto.error.NotFoundException;
import com.yourschool.server.entity.employee.ScEmployeeAttendence;
import com.yourschool.server.service.common.CommonService;
import com.yourschool.server.util.ScDateUtil;
import com.yourschool.server.util.ScUtil;
import com.yourschool.server.vo.FieldType;
import com.yourschool.server.vo.Filter;
import com.yourschool.server.vo.Operator;

@Service
public class ScEmployeeAttendenceService {

	@Autowired
	private CommonService commonService;

	public EmployeeAttendencesResponse findAllEmployeeAttendence() {

		EmployeeAttendencesResponse res = new EmployeeAttendencesResponse();

		List<ScEmployeeAttendence> employeeAttendences = commonService.findAll(ScEmployeeAttendence.class);
		if (!ScUtil.isAllPresent(employeeAttendences))
			throw new NotFoundException("No employee attendence  can be found !");

		List<EmployeeAttendence> dtoEmployeeAttendences = new ArrayList<>();
		employeeAttendences.forEach(employeeAttendence -> {
			EmployeeAttendence dtoEmployeeAttendence = setEmployeeAttendenceToDto(employeeAttendence);
			dtoEmployeeAttendences.add(dtoEmployeeAttendence);
		});

		res.setApiMessage(ApiUtil.okMessage("Success"));
		res.setData(dtoEmployeeAttendences);
		return res;
	}

	private EmployeeAttendence setEmployeeAttendenceToDto(ScEmployeeAttendence employeeAttendence) {

		EmployeeAttendence dtoEmployeeAttendence = new EmployeeAttendence();
		dtoEmployeeAttendence.setComment(employeeAttendence.getComment());
		dtoEmployeeAttendence.setDate(employeeAttendence.getDate());
		dtoEmployeeAttendence.setDay(employeeAttendence.getDay());
		dtoEmployeeAttendence.setEmail(employeeAttendence.getEmail());
		dtoEmployeeAttendence.setId(employeeAttendence.getId());
		dtoEmployeeAttendence.setTimeIn(employeeAttendence.getTimeIn());
		dtoEmployeeAttendence.setTimeOut(employeeAttendence.getTimeOut());
		dtoEmployeeAttendence.setTotal(employeeAttendence.getTotal());

		return dtoEmployeeAttendence;
	}

	public EmployeeAttendenceResponse findEmployeeAttendence(Long id) {

		EmployeeAttendenceResponse res = new EmployeeAttendenceResponse();

		ScEmployeeAttendence employeeAttendence = commonService.findById(id, EmployeeAttendence.class);

		if (!ScUtil.isAllPresent(employeeAttendence))
			throw new NotFoundException("No employee attendence can be found !");

		EmployeeAttendence dtoEmployeeAttendence = setEmployeeAttendenceToDto(employeeAttendence);

		res.setApiMessage(ApiUtil.okMessage("Success"));
		res.setData(dtoEmployeeAttendence);

		return res;
	}

	public EmployeeAttendenceResponse findEmployeeAttendence(String email, String dateStr) {

		EmployeeAttendenceResponse res = new EmployeeAttendenceResponse();

		dateStr = dateStr.replaceAll("-", "\\/");

		Date date = ScDateUtil.stringToDate(dateStr);

		List<Filter> filters = new ArrayList<Filter>();
		filters.add(new Filter("email", Operator.EQUAL, FieldType.STRING, email));
		filters.add(new Filter("date", Operator.EQUAL, FieldType.DATE, date));

		ScEmployeeAttendence employeeAttendence = commonService.findOne(filters, ScEmployeeAttendence.class);

		if (!ScUtil.isAllPresent(employeeAttendence))
			throw new NotFoundException("No employee attendence can be found !");

		EmployeeAttendence dtoEmployeeAttendence = setEmployeeAttendenceToDto(employeeAttendence);

		res.setApiMessage(ApiUtil.okMessage("Success"));
		res.setData(dtoEmployeeAttendence);

		return res;
	}

	public ActionResponse createOrUpdateEmployeeAttendence(EmployeeAttendence dtoEmployeeAttendence, Long id) {

		ActionResponse res = new ActionResponse();

		ScEmployeeAttendence employeeAttendence = setDtoToEmployeeAttendence(dtoEmployeeAttendence, id);

		commonService.save(employeeAttendence);

		String message = "";
		if (ScUtil.isAllPresent(id)) {
			message = "Successfully updated employee attendence data";
			res.setApiMessage(ApiUtil.okMessage(message));
		} else {
			message = "Successfully created an employee attendence";
			res.setApiMessage(ApiUtil.createdMessage(message));
			res.setActionMessage(message);
		}

		return res;
	}

	private ScEmployeeAttendence setDtoToEmployeeAttendence(EmployeeAttendence dtoEmployeeAttendence, Long id) {

		ScEmployeeAttendence employeeAttendence = new ScEmployeeAttendence();
		employeeAttendence.setComment(dtoEmployeeAttendence.getComment());
		employeeAttendence.setDate(dtoEmployeeAttendence.getDate());
		employeeAttendence.setDay(dtoEmployeeAttendence.getDay());
		employeeAttendence.setEmail(dtoEmployeeAttendence.getEmail());
		employeeAttendence.setId(dtoEmployeeAttendence.getId());
		employeeAttendence.setTimeIn(dtoEmployeeAttendence.getTimeIn());
		employeeAttendence.setTimeOut(dtoEmployeeAttendence.getTimeOut());
		employeeAttendence.setTotal(dtoEmployeeAttendence.getTotal());
		return employeeAttendence;
	}

	public ActionResponse deleteEmployeeAttendence(Long id) {

		ActionResponse res = new ActionResponse();

		ScEmployeeAttendence employeeAttendence = commonService.findById(id, ScEmployeeAttendence.class);

		if (!ScUtil.isAllPresent(employeeAttendence))
			throw new NotFoundException("No employee attendence can be found !");

		commonService.delete(employeeAttendence);

		res.setActionMessage("Employee attendence has been deleted successfully");
		res.setApiMessage(ApiUtil.okMessage("Employee attendence  has been deleted successfully"));
		return res;
	}

}
