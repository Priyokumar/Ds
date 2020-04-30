package com.yourschool.server.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourschool.server.dto.ActionResponse;
import com.yourschool.server.dto.ApiUtil;
import com.yourschool.server.dto.error.NotFoundException;
import com.yourschool.server.dto.incomeAndExpense.Income;
import com.yourschool.server.dto.incomeAndExpense.IncomeResponse;
import com.yourschool.server.dto.incomeAndExpense.IncomesResponse;
import com.yourschool.server.entity.employee.ScRecordAudit;
import com.yourschool.server.entity.incomeAndExpense.ScIncome;
import com.yourschool.server.service.common.CommonService;
import com.yourschool.server.util.ScDateUtil;
import com.yourschool.server.util.ScUtil;

@Service
public class ScIncomeService {

	@Autowired
	private CommonService commonService;

	public IncomesResponse findAllIncome() {

		IncomesResponse res = new IncomesResponse();

		List<ScIncome> incomes = commonService.findAll(ScIncome.class);
		if (!ScUtil.isAllPresent(incomes))
			throw new NotFoundException("No income can be found !");

		List<Income> dtoIncomes = new ArrayList<>();
		incomes.forEach(income -> {
			Income dtoIncome = setIncomeToDto(income);
			dtoIncomes.add(dtoIncome);
		});

		res.setApiMessage(ApiUtil.okMessage("Success"));
		res.setData(dtoIncomes);
		return res;
	}

	public IncomeResponse findIncome(Long id) {

		IncomeResponse res = new IncomeResponse();

		ScIncome income = commonService.findById(id, ScIncome.class);

		if (!ScUtil.isAllPresent(income))
			throw new NotFoundException("No income can be found !");

		Income incomeDto = setIncomeToDto(income);
		res.setApiMessage(ApiUtil.okMessage("Success"));
		res.setData(incomeDto);

		return res;
	}

	public ActionResponse createOrUpdateIncome(Income dtoIncome, Long id) {

		ActionResponse res = new ActionResponse();

		ScIncome income = setDtoToIncome(dtoIncome, id);

		commonService.save(income);

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

	private ScIncome setDtoToIncome(Income dtoIncome, Long id) {

		ScIncome income = new ScIncome();

		if (ScUtil.isAllPresent(id))
			income = commonService.findById(id, ScIncome.class);

		if (!ScUtil.isAllPresent(income))
			throw new NotFoundException("No income can be found !");

		income.setAmount(dtoIncome.getAmount());
		income.setComments(dtoIncome.getComments());
		income.setId(dtoIncome.getId());
		income.setIncomeDate(ScDateUtil.now());
		income.setIncomeDetails(dtoIncome.getIncomeDetails());
		income.setIncomeType(dtoIncome.getIncomeType());
		if (!ScUtil.isAllPresent(id))
			income.setRefNo(ScUtil.getGeneratedNumber("INC"));
		ScRecordAudit recordAudit = ScUtil.recordAudit(null, id);//// TODO need to pass user
		income.setRecordAudit(recordAudit);

		return income;
	}

	public ActionResponse deleteIncome(Long id) {

		ActionResponse res = new ActionResponse();

		ScIncome income = commonService.findById(id, ScIncome.class);

		if (!ScUtil.isAllPresent(income))
			throw new NotFoundException("No income can be found !");

		commonService.delete(income);

		res.setActionMessage("Income has been deleted successfully");
		res.setApiMessage(ApiUtil.okMessage("Income has been deleted successfully"));
		return res;
	}

	private Income setIncomeToDto(ScIncome income) {

		Income dtoIncome = new Income();

		dtoIncome.setAmount(income.getAmount());
		dtoIncome.setComments(income.getComments());
		dtoIncome.setId(income.getId());
		dtoIncome.setIncomeDate(ScDateUtil.dateToString(income.getIncomeDate()));
		dtoIncome.setIncomeDetails(income.getIncomeDetails());
		dtoIncome.setIncomeType(income.getIncomeType());
		dtoIncome.setRefNo(income.getRefNo()); 

		return dtoIncome;
	}

}
