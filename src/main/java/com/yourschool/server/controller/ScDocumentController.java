package com.yourschool.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.yourschool.server.dto.ActionResponse;
import com.yourschool.server.service.ScTempUploadService;

@RestController
@RequestMapping("/document")
public class ScDocumentController {

	@Autowired
	private ScTempUploadService tempUploadService;

	@GetMapping(value = "/{id}/view")
	public ResponseEntity<Resource> getDocument(@PathVariable("id") Long id) {

		Resource resourceFile = tempUploadService.loadFile(id);

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resourceFile.getFilename() + "\"")
				.body(resourceFile);
	}

	@PostMapping(value = "/{id}/upload")
	public ActionResponse updateDocument(@RequestParam("file") MultipartFile file,
			@RequestParam("documentBody") String documentBodyStr, @PathVariable("id") Long id) {
		return tempUploadService.updateDocument(id, file, documentBodyStr);
	}
}
