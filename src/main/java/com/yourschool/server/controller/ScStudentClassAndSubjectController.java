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
import com.yourschool.server.dto.student.StudentClass;
import com.yourschool.server.dto.student.StudentClassResponse;
import com.yourschool.server.dto.student.StudentClassesReponse;
import com.yourschool.server.service.ScStudentClassService;

@RestController
@RequestMapping("/api/class")
public class ScStudentClassAndSubjectController {

	@Autowired
	private ScStudentClassService studentClassService;

	@GetMapping
	public StudentClassesReponse findAllStudentClass() {
		return studentClassService.findAllStudentClass();
	}

	@GetMapping(value = "/{id}")
	public StudentClassResponse findStudentClass(@PathVariable("id") Long id) {
		return studentClassService.findStudentClass(id);
	}

	@PostMapping
	public ActionResponse createStudentClass(@RequestBody StudentClass dtoStudentClass) {
		return studentClassService.createOrUpdateStudentClass(dtoStudentClass, null);
	}

	@PutMapping(value = "/{id}")
	public ActionResponse updateStudentClass(@RequestBody StudentClass dtoStudentClass, @PathVariable("id") Long id) {
		return studentClassService.createOrUpdateStudentClass(dtoStudentClass, id);
	}

	@DeleteMapping(value = "/{id}")
	public ActionResponse deleteStudentClass(@PathVariable("id") Long id) {
		return studentClassService.deleteStudentClass(id);
	}
}
