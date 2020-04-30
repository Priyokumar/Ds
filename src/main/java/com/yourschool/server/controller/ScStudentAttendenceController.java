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
import com.yourschool.server.dto.student.StudentAttendence;
import com.yourschool.server.dto.student.StudentAttendenceResponse;
import com.yourschool.server.dto.student.StudentAttendencesResponse;
import com.yourschool.server.service.ScStudentAttendenceService;

@RestController
@RequestMapping("/api/student-attendence")
public class ScStudentAttendenceController {

	@Autowired
	private ScStudentAttendenceService scStudentAttendenceService;

	@GetMapping
	public StudentAttendencesResponse findStudentAttendence() {
		return scStudentAttendenceService.findAllStudentAttendence();
	}

	@GetMapping(value = "/{id}")
	public StudentAttendenceResponse findStudentAttendence(@PathVariable("id") Long id) {
		return scStudentAttendenceService.findStudentAttendence(id);
	}

	@PostMapping
	public ActionResponse createStudentAttendence(@RequestBody StudentAttendence studentAttendence) {
		return scStudentAttendenceService.createOrUpdateStudentAttendence(studentAttendence, null);
	}

	@PutMapping(value = "/{id}")
	public ActionResponse updateStudentAttendence(@RequestBody StudentAttendence studentAttendence,
			@PathVariable("id") Long id) {
		return scStudentAttendenceService.createOrUpdateStudentAttendence(studentAttendence, id);
	}

	@DeleteMapping(value = "/{id}")
	public ActionResponse deleteStudentAttendence(@PathVariable("id") Long id) {
		return scStudentAttendenceService.deleteStudentAttendence(id);
	}
}
