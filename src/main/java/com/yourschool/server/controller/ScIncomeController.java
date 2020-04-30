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
import com.yourschool.server.dto.incomeAndExpense.Income;
import com.yourschool.server.dto.incomeAndExpense.IncomeResponse;
import com.yourschool.server.dto.incomeAndExpense.IncomesResponse;
import com.yourschool.server.service.ScIncomeService;

@RestController
@RequestMapping("/api/incomes")
public class ScIncomeController {

	@Autowired
	private ScIncomeService scIncomeService;

	@GetMapping
	public IncomesResponse findAllIncome() {
		return scIncomeService.findAllIncome();
	}

	@GetMapping(value = "/{id}")
	public IncomeResponse findIncome(@PathVariable("id") Long id) {
		return scIncomeService.findIncome(id);
	}

	@PostMapping
	public ActionResponse createIncome(@RequestBody Income income) {
		return scIncomeService.createOrUpdateIncome(income, null);
	}

	@PutMapping(value = "/{id}")
	public ActionResponse updateIncome(@RequestBody Income income, @PathVariable("id") Long id) {
		return scIncomeService.createOrUpdateIncome(income, id);
	}

	@DeleteMapping(value = "/{id}")
	public ActionResponse deleteIncome(@PathVariable("id") Long id) {
		return scIncomeService.deleteIncome(id);
	}
}
