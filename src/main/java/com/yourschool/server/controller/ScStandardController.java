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
import com.yourschool.server.dto.maintenance.Standard;
import com.yourschool.server.dto.maintenance.StandardResponse;
import com.yourschool.server.dto.maintenance.StandardsResponse;
import com.yourschool.server.service.ScStandardService;

@RestController
@RequestMapping("/api/standard")
public class ScStandardController {

	@Autowired
	private ScStandardService scStandardService;

	@GetMapping
	public StandardsResponse findAllStandard() {
		return scStandardService.findAllStandard();
	}

	@GetMapping(value = "/{id}")
	public StandardResponse findStandard(@PathVariable("id") Long id) {
		return scStandardService.findStandard(id);
	}

	@PostMapping
	public ActionResponse createStandard(@RequestBody Standard standard) {
		return scStandardService.createOrUpdateStandard(standard, null);
	}

	@PutMapping(value = "/{id}")
	public ActionResponse updateStandard(@RequestBody Standard standard, @PathVariable("id") Long id) {
		return scStandardService.createOrUpdateStandard(standard, id);
	}

	@DeleteMapping(value = "/{id}")
	public ActionResponse deleteStandard(@PathVariable("id") Long id) {
		return scStandardService.deleteStandard(id);
	}
}
