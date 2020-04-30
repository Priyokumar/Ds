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
import com.yourschool.server.dto.employee.EmployeeAttendence;
import com.yourschool.server.dto.employee.EmployeeAttendenceResponse;
import com.yourschool.server.dto.employee.EmployeeAttendencesResponse;
import com.yourschool.server.service.ScEmployeeAttendenceService;

@RestController
@RequestMapping("/api/employee-attendances")
public class ScEmployeeAttendenceController {

	@Autowired
	private ScEmployeeAttendenceService employeeAttendenceService;

	@GetMapping
	public EmployeeAttendencesResponse findAllEmployeeAttendence() {
		return employeeAttendenceService.findAllEmployeeAttendence();
	}

	@GetMapping(value = "/{id}")
	public EmployeeAttendenceResponse findEmployeeAttendence(@PathVariable("id") Long id) {
		return employeeAttendenceService.findEmployeeAttendence(id);
	}
	
	@GetMapping(value = "/email/{email}/date/{date}")
	public EmployeeAttendenceResponse findEmployeeAttendence(@PathVariable("email") String email,@PathVariable("date") String date) {
		return employeeAttendenceService.findEmployeeAttendence(email,date);
	}

	@PostMapping
	public ActionResponse createEmployeeAttendence(@RequestBody EmployeeAttendence dtoEmployeeAttendence) {
		return employeeAttendenceService.createOrUpdateEmployeeAttendence(dtoEmployeeAttendence, null);
	}

	@PutMapping(value = "/{id}")
	public ActionResponse updateEmployeeAttendence(@RequestBody EmployeeAttendence dtoEmployeeAttendence,
			@PathVariable("id") Long id) {
		return employeeAttendenceService.createOrUpdateEmployeeAttendence(dtoEmployeeAttendence, id);
	}

	@DeleteMapping(value = "/{id}")
	public ActionResponse deleteEmployeeAttendence(@PathVariable("id") Long id) {
		return employeeAttendenceService.deleteEmployeeAttendence(id);
	}
}
