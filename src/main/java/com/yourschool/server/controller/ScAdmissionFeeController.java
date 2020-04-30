package com.yourschool.server.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yourschool.server.dto.ActionResponse;
import com.yourschool.server.dto.admissionFee.AdmissionMonthly;
import com.yourschool.server.dto.admissionFee.Admission;
import com.yourschool.server.dto.admissionFee.AdmissionFeeResponse;
import com.yourschool.server.dto.admissionFee.AdmissionFeesResponse;
import com.yourschool.server.dto.admissionFee.FeesResponse;
import com.yourschool.server.service.ScAdmissionFeeService;

@RestController
@RequestMapping("/api/admission-fees")
public class ScAdmissionFeeController {

	@Autowired
	private ScAdmissionFeeService admissionFeeService;

	@GetMapping
	private AdmissionFeesResponse findAllAdmissionFee(@RequestParam Map<String, String> allParams) {
		return admissionFeeService.findAllAdmissionFee(allParams);
	}

	@GetMapping(value = "/{id}")
	private AdmissionFeeResponse findAdmissionFee(@PathVariable("id") Long id) {
		return admissionFeeService.findAdmissionFee(id);
	}

	@PostMapping
	private ActionResponse createAdmissionFee(@RequestBody Admission admission) {
		return admissionFeeService.createOrUpdateAdmissionFee(admission, null);
	}

	@PutMapping(value = "/{id}")
	private ActionResponse updateAdmissionFee(@RequestBody Admission admission, @PathVariable("id") Long id) {
		return admissionFeeService.createOrUpdateAdmissionFee(admission, id);
	}
	
	@PutMapping(value = "/{id}/fee/{feeId}")
	private ActionResponse payFee(@RequestBody Admission admission, @PathVariable("id") Long id, @PathVariable("feeId") Long feeId) {
		return admissionFeeService.payFee(feeId);
	}

	@DeleteMapping(value = "/{id}")
	private ActionResponse deleteAdmissionFee(@PathVariable("id") Long id) {
		return admissionFeeService.deleteAdmissionFee(id);
	}

	@GetMapping(value = "fees/{standard}/{year}")
	private FeesResponse findFeesByStandard(@PathVariable("standard") String standard, @PathVariable("year") String year) {
		return admissionFeeService.findFeesByStandard(standard, year);
	}
	
	@GetMapping(value = "year/{year}")
	private List<AdmissionMonthly> admissionsByYear(@PathVariable("year") int year) {
		return admissionFeeService.getAdmissionDashboardData(year);
	}

}
