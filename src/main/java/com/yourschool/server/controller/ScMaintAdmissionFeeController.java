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
import com.yourschool.server.dto.maintenance.MaintAdmissionFeeResponse;
import com.yourschool.server.dto.maintenance.MaintAdmissionFeeYearlyResponse;
import com.yourschool.server.dto.maintenance.MaintAdmissionFeesYearlyResponse;
import com.yourschool.server.dto.maintenance.MaintenanceAdmissionFeeYearly;
import com.yourschool.server.service.ScMaintAdmissionFeeService;

@RestController
@RequestMapping("/api/maintenance/admission-fees")
public class ScMaintAdmissionFeeController {

	@Autowired
	private ScMaintAdmissionFeeService maintAdmissionFeeService;

	@GetMapping
	private MaintAdmissionFeesYearlyResponse findAllMaintAdmissionFees() {
		return maintAdmissionFeeService.findAllMaintAdmissionFees();
	}

	@GetMapping(value = "/{id}")
	private MaintAdmissionFeeYearlyResponse findMaintAdmissionFee(@PathVariable("id") Long id) {
		return maintAdmissionFeeService.findMaintAdmissionFee(id);
	}

	@PostMapping
	private ActionResponse createMaintAdmissionFee(@RequestBody MaintenanceAdmissionFeeYearly maintAdmissionFeeYearly) {
		return maintAdmissionFeeService.createOrUpdateMaintAdmissionFee(maintAdmissionFeeYearly, null);
	}

	@PutMapping(value = "/{id}")
	private ActionResponse updateMaintAdmissionFee(@RequestBody MaintenanceAdmissionFeeYearly maintAdmissionFeeYearly,
			@PathVariable("id") Long id) {
		return maintAdmissionFeeService.createOrUpdateMaintAdmissionFee(maintAdmissionFeeYearly, id);
	}

	@DeleteMapping(value = "/{id}")
	private ActionResponse deleteMaintAdmissionFee(@PathVariable("id") Long id) {
		return maintAdmissionFeeService.deleteMaintAdmissionFee(id);
	}

	@GetMapping(value = "/{standard}/{year}/standard-year")
	private MaintAdmissionFeeResponse findMaintAdmissionFeeByStandard(@PathVariable("standard") String standard,@PathVariable("year") String year) {
		return maintAdmissionFeeService.findMaintAdmissionFeeByStandard(standard,year);
	}
}
