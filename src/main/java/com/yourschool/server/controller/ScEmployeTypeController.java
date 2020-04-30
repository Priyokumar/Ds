package com.yourschool.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yourschool.server.dto.empType.Designation;
import com.yourschool.server.dto.empType.EmployeeType;
import com.yourschool.server.service.ScEmployeeTypeService;

@RestController
@RequestMapping("/api/employee-type")
public class ScEmployeTypeController {
	
	@Autowired
	private ScEmployeeTypeService employeeTypeService;
	
	@GetMapping
	public List<EmployeeType> findAllEmployeeTypes() {
		return employeeTypeService.findEmployeeTypes();
	}
	
	@GetMapping(value = "/{name}")
	public EmployeeType findEmployeeType(@PathVariable("name") String name) {
		return employeeTypeService.findEmployeeTypeById(name);
	}
	
	@GetMapping(value = "/{name}/designations")
	public List<Designation>  findDesignationsByEmployeeType(@PathVariable("name") String name) {
		return employeeTypeService.findDesignationsByEmployeeType(name);
	}
	
	@GetMapping(value = "/designations/{name}")
	public Designation  findDesignationById(@PathVariable("name") String name) {
		return employeeTypeService.findDesignationById(name);
	}

}
