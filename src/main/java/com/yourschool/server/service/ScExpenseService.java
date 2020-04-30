package com.yourschool.server.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourschool.server.dto.ActionResponse;
import com.yourschool.server.dto.ApiUtil;
import com.yourschool.server.dto.error.NotFoundException;
import com.yourschool.server.dto.incomeAndExpense.Expense;
import com.yourschool.server.dto.incomeAndExpense.ExpenseResponse;
import com.yourschool.server.dto.incomeAndExpense.ExpensesResponse;
import com.yourschool.server.entity.employee.ScRecordAudit;
import com.yourschool.server.entity.incomeAndExpense.ScExpense;
import com.yourschool.server.service.common.CommonService;
import com.yourschool.server.util.ScDateUtil;
import com.yourschool.server.util.ScUtil;

@Service
public class ScExpenseService {

	@Autowired
	private CommonService commonService;

	public ExpensesResponse findAllExpenses() {

		ExpensesResponse res = new ExpensesResponse();

		List<ScExpense> expenses = commonService.findAll(ScExpense.class);
		if (!ScUtil.isAllPresent(expenses))
			throw new NotFoundException("No expense can be found !");

		List<Expense> dtoExpenses = new ArrayList<>();
		expenses.forEach(expense -> {
			Expense dtoExpense = setExpenseToDto(expense);
			dtoExpenses.add(dtoExpense);
		});

		res.setApiMessage(ApiUtil.okMessage("Success"));
		res.setData(dtoExpenses);
		return res;
	}

	public ExpenseResponse findExpense(Long id) {

		ExpenseResponse res = new ExpenseResponse();

		ScExpense expense = commonService.findById(id, ScExpense.class);

		if (!ScUtil.isAllPresent(expense))
			throw new NotFoundException("No expense can be found !");

		Expense expenseDto = setExpenseToDto(expense);
		res.setApiMessage(ApiUtil.okMessage("Success"));
		res.setData(expenseDto);

		return res;
	}

	public ActionResponse createOrUpdateExpense(Expense dtoExpense, Long id) {

		ActionResponse res = new ActionResponse();

		ScExpense expense = setDtoToExpense(dtoExpense, id);

		commonService.save(expense);

		String message = "";
		if (ScUtil.isAllPresent(id)) {
			message = "Successfully updated income data";
			res.setApiMessage(ApiUtil.okMessage(message));
		} else {
			message = "Successfully created an income";
			res.setApiMessage(ApiUtil.createdMessage(message));
			res.setActionMessage(message);
		}

		return res;
	}

	public ActionResponse deleteExpense(Long id) {

		ActionResponse res = new ActionResponse();

		ScExpense expense = commonService.findById(id, ScExpense.class);

		if (!ScUtil.isAllPresent(expense))
			throw new NotFoundException("No expense can be found !");

		commonService.delete(expense);

		res.setActionMessage("Expense has been deleted successfully");
		res.setApiMessage(ApiUtil.okMessage("Expense has been deleted successfully"));
		return res;
	}

	private Expense setExpenseToDto(ScExpense expense) {

		Expense dtoExpense = new Expense();

		dtoExpense.setAmount(expense.getAmount());
		dtoExpense.setComments(expense.getComments());
		dtoExpense.setExpenseDate(ScDateUtil.dateToString(expense.getExpenseDate()));
		dtoExpense.setExpenseDetails(expense.getExpenseType());
		dtoExpense.setExpenseType(expense.getExpenseType());
		dtoExpense.setId(expense.getId());
		dtoExpense.setRefNo(expense.getRefNo());

		return dtoExpense;
	}

	private ScExpense setDtoToExpense(Expense dtoExpense, Long id) {

		ScExpense expense = new ScExpense();

		if (ScUtil.isAllPresent(id))
			expense = commonService.findById(id, ScExpense.class);

		if (!ScUtil.isAllPresent(expense))
			throw new NotFoundException("No expense can be found !");

		expense.setAmount(dtoExpense.getAmount());
		expense.setComments(dtoExpense.getComments());
		expense.setId(dtoExpense.getId());
		expense.setExpenseDate(ScDateUtil.now());
		expense.setExpenseDetails(dtoExpense.getExpenseDetails());
		expense.setExpenseType(dtoExpense.getExpenseType());
		if (!ScUtil.isAllPresent(id))
			expense.setRefNo(ScUtil.getGeneratedNumber("EXP"));
		ScRecordAudit recordAudit = ScUtil.recordAudit(null, id);//// TODO need to pass user
		expense.setRecordAudit(recordAudit);

		return expense;
	}

}
