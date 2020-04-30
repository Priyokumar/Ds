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
import com.yourschool.server.dto.incomeAndExpense.Expense;
import com.yourschool.server.dto.incomeAndExpense.ExpenseResponse;
import com.yourschool.server.dto.incomeAndExpense.ExpensesResponse;
import com.yourschool.server.service.ScExpenseService;

@RestController
@RequestMapping("/api/expenses")
public class ScExpenseController {

	@Autowired
	private ScExpenseService expenseService;

	@GetMapping
	public ExpensesResponse findAllExpenses() {
		return expenseService.findAllExpenses();
	}

	@GetMapping(value = "/{id}")
	public ExpenseResponse findExpense(@PathVariable("id") Long id) {
		return expenseService.findExpense(id);
	}

	@PostMapping
	public ActionResponse createExpense(@RequestBody Expense expense) {
		return expenseService.createOrUpdateExpense(expense, null);
	}

	@PutMapping(value = "/{id}")
	public ActionResponse updateExpense(@RequestBody Expense expense, @PathVariable("id") Long id) {
		return expenseService.createOrUpdateExpense(expense, id);
	}

	@DeleteMapping(value = "/{id}")
	public ActionResponse deleteExpense(@PathVariable("id") Long id) {
		return expenseService.deleteExpense(id);
	}
}
