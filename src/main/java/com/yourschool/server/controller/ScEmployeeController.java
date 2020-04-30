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
import com.yourschool.server.dto.employee.Employee;
import com.yourschool.server.dto.employee.EmployeeResponse;
import com.yourschool.server.dto.employee.EmployeesResponse;
import com.yourschool.server.service.ScEmployeeService;

@RestController
@RequestMapping("/api/employees")
public class ScEmployeeController {

	@Autowired
	private ScEmployeeService employeeService;

	@GetMapping
	public EmployeesResponse findAllEmployee() {
		return employeeService.findAllEmployee();
	}

	@GetMapping(value = "/{id}")
	public EmployeeResponse findEmployee(@PathVariable("id") Long id) {
		return employeeService.findEmployee(id);
	}
	
	@GetMapping(value = "/email/{email}")
	public EmployeeResponse findEmployeeAttendence(@PathVariable("email") String email) {
		return employeeService.findEmployee(email);
	}

	@PostMapping
	public ActionResponse createEmployee(@RequestBody Employee employee) {
		return employeeService.createOrUpdateEmployee(employee, null);
	}

	@PutMapping(value = "/{id}")
	public ActionResponse updateEmployee(@RequestBody Employee employee, @PathVariable("id") Long id) {
		return employeeService.createOrUpdateEmployee(employee, id);
	}

	@DeleteMapping(value = "/{id}")
	public ActionResponse deleteEmployee(@PathVariable("id") Long id) {
		return employeeService.deleteEmployee(id);
	}
	
	@GetMapping(value = "/teaching-staffs")
	public EmployeesResponse findAllTeachingStaffs() {
		return employeeService.findAllEmployee();
	}



}
