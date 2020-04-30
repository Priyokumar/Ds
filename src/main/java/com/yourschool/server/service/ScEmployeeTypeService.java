package com.yourschool.server.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourschool.server.dto.empType.Designation;
import com.yourschool.server.dto.empType.EmployeeType;
import com.yourschool.server.entity.empType.ScDesignation;
import com.yourschool.server.entity.empType.ScEmployeeType;
import com.yourschool.server.service.common.CommonService;
import com.yourschool.server.util.ScUtil;
import com.yourschool.server.vo.FieldType;
import com.yourschool.server.vo.Filter;
import com.yourschool.server.vo.Operator;

@Service
public class ScEmployeeTypeService {

	@Autowired
	private CommonService commonService;

	public List<EmployeeType> findEmployeeTypes() {

		List<EmployeeType> dtoEmployeeTypes = new ArrayList<>();

		List<ScEmployeeType> employeeTypes = commonService.findAll(ScEmployeeType.class);

		if (ScUtil.isAllPresent(employeeTypes)) {
			dtoEmployeeTypes = setEmployeeTypesToDto(employeeTypes);
		}

		return dtoEmployeeTypes;
	}

	private List<EmployeeType> setEmployeeTypesToDto(List<ScEmployeeType> employeeTypes) {

		if (!ScUtil.isAllPresent(employeeTypes))
			return null;

		List<EmployeeType> dtoEmployeeTypes = new ArrayList<>();
		employeeTypes.forEach(employeeType -> {

			EmployeeType dtoEmployeeType = setEmployeeTypeToDto(employeeType);
			dtoEmployeeTypes.add(dtoEmployeeType);

		});
		return dtoEmployeeTypes;
	}

	private EmployeeType setEmployeeTypeToDto(ScEmployeeType employeeType) {

		EmployeeType dtoEmployeeType = new EmployeeType();

		dtoEmployeeType.setDescription(employeeType.getDescription());

		dtoEmployeeType.setId(employeeType.getId());
		dtoEmployeeType.setName(employeeType.getName());

		if (ScUtil.isAllPresent(employeeType.getDesignations())) {

			List<Designation> dtoDesignations = new ArrayList<>();

			employeeType.getDesignations().forEach(designation -> {

				Designation dtoDesignation = new Designation();
				dtoDesignation.setDescription(designation.getDescription());
				dtoDesignation.setId(designation.getId());
				dtoDesignation.setName(designation.getName());
				dtoDesignations.add(dtoDesignation);
			});
			dtoEmployeeType.setDesignations(dtoDesignations);
		}
		return dtoEmployeeType;
	}

	public EmployeeType findEmployeeTypeById(String name) {

		EmployeeType dtoEmployeeType = new EmployeeType();
		
		List<Filter> filters = new ArrayList<>();
		filters.add(new Filter("name", Operator.EQUAL, FieldType.STRING, name));
		ScEmployeeType employeeType = commonService.findOne(filters, ScEmployeeType.class);

		if (ScUtil.isAllPresent(employeeType)) {
			dtoEmployeeType = setEmployeeTypeToDto(employeeType);
		}
		return dtoEmployeeType;
	}

	public List<Designation> findDesignationsByEmployeeType(String name) {

		List<Designation> dtoDesignations = new ArrayList<>();

		List<Filter> filters = new ArrayList<>();
		filters.add(new Filter("name", Operator.EQUAL, FieldType.STRING, name));
		ScEmployeeType employeeType = commonService.findOne(filters, ScEmployeeType.class);

		if (ScUtil.isAllPresent(employeeType)) {
			dtoDesignations = setDesignationsToDto(employeeType.getDesignations());
		}
		return dtoDesignations;
	}
	
	public Designation findDesignationById(String name) {

		Designation dtoDesignation = new Designation();
		
		List<Filter> filters = new ArrayList<>();
		filters.add(new Filter("name", Operator.EQUAL, FieldType.STRING, name));
		ScDesignation designation = commonService.findOne(filters, ScDesignation.class);

		if (ScUtil.isAllPresent(designation)) {
			dtoDesignation = setDesignationToDto(designation);
		}
		return dtoDesignation;
	}	

	private List<Designation> setDesignationsToDto(List<ScDesignation> designations) {

		if (!ScUtil.isAllPresent(designations))
			return null;

		List<Designation> dtodesginations = new ArrayList<>();
		designations.forEach(designation -> {

			Designation dtoDesignation = setDesignationToDto(designation);
			dtodesginations.add(dtoDesignation);

		});
		return dtodesginations;
	}

	private Designation setDesignationToDto(ScDesignation designation) {

		Designation dtoDesignation = new Designation();

		dtoDesignation.setDescription(designation.getDescription());
		dtoDesignation.setId(designation.getId());
		dtoDesignation.setName(designation.getName());

		return dtoDesignation;
	}

}
