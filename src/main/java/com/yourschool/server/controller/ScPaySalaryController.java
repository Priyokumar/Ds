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
import com.yourschool.server.dto.employee.PaySalariesResponse;
import com.yourschool.server.dto.employee.PaySalary;
import com.yourschool.server.dto.employee.PaySalaryResponse;
import com.yourschool.server.service.ScPaySalaryService;

@RestController
@RequestMapping("/api/pay-salaries")
public class ScPaySalaryController {

	@Autowired
	private ScPaySalaryService paySalaryService;

	@GetMapping
	public PaySalariesResponse findAllPaySalary() {
		return paySalaryService.findAllPaySalary();
	}

	@GetMapping(value = "/{id}")
	public PaySalaryResponse findPaySalary(@PathVariable("id") Long id) {
		return paySalaryService.findPaySalary(id);
	}

	@PostMapping
	public ActionResponse createPaySalary(@RequestBody PaySalary dtoPaySalary) {
		return paySalaryService.createOrUpdatePaySalary(dtoPaySalary, null);
	}

	@PutMapping(value = "/{id}")
	public ActionResponse updatePaySalary(@RequestBody PaySalary dtoPaySalary, @PathVariable("id") Long id) {
		return paySalaryService.createOrUpdatePaySalary(dtoPaySalary, id);
	}

	@DeleteMapping(value = "/{id}")
	public ActionResponse deletePaySalary(@PathVariable("id") Long id) {
		System.out.println("\n\n\n\n\n");
		System.out.println("delete");
		System.out.println("\n\n\n\n\n");
		return paySalaryService.deletePaySalary(id);
	}
}
