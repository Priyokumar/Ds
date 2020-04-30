package com.yourschool.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yourschool.server.dto.ActionResponse;
import com.yourschool.server.dto.employee.EmployeeSalariesResponse;
import com.yourschool.server.dto.employee.EmployeeSalary;
import com.yourschool.server.dto.employee.EmployeeSalaryResponse;
import com.yourschool.server.service.ScEmployeeSalaryService;

@RestController
@RequestMapping("/api/salaries")
public class ScEmployeeSalaryController {

	@Autowired
	private ScEmployeeSalaryService employeeSalaryService;

	@GetMapping
	public EmployeeSalariesResponse findAllEmployeeSalary() {
		return employeeSalaryService.findAllEmployeeSalary();
	}

	@GetMapping(value = "/{id}")
	public EmployeeSalaryResponse findEmployeeSalary(@PathVariable("id") Long id) {
		return employeeSalaryService.findEmployeeSalary(id);
	}

	@PostMapping
	public ActionResponse createEmployeeSalary(@RequestBody EmployeeSalary dtoEmployeeSalary) {
		return employeeSalaryService.createOrUpdateEmployeeSalary(dtoEmployeeSalary, null);
	}

	@PutMapping(value = "/{id}")
	public ActionResponse updateEmployeeSalary(@RequestBody EmployeeSalary dtoEmployeeSalary,
			@PathVariable("id") Long id) {
		return employeeSalaryService.createOrUpdateEmployeeSalary(dtoEmployeeSalary, id);
	}

	@DeleteMapping(value = "/{id}")
	public ActionResponse deleteEmployeeSalary(@PathVariable("id") Long id) {
		return employeeSalaryService.deleteEmployeeSalary(id);
	}
	
	@GetMapping(value = "/{empId}/employee")
	public EmployeeSalaryResponse findEmployeeSalaryByEmpId(@PathVariable("empId") Long empId) {
		return employeeSalaryService.findEmployeeSalaryByEmpId(empId);
	}
	
	@PutMapping(value = "/{id}/update-salary")
	public ActionResponse updateSalary(@RequestBody EmployeeSalary dtoEmployeeSalary,
			@PathVariable("id") Long id) {
		return employeeSalaryService.updateSalary(dtoEmployeeSalary, id);
	}
}
