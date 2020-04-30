package com.yourschool.server.service;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yourschool.server.dto.ActionResponse;
import com.yourschool.server.dto.ApiUtil;
import com.yourschool.server.dto.DocumentBody;
import com.yourschool.server.dto.error.BadRequestException;
import com.yourschool.server.dto.error.InternalServerException;
import com.yourschool.server.dto.error.NotFoundException;
import com.yourschool.server.entity.ScDocument;
import com.yourschool.server.entity.employee.ScEmployee;
import com.yourschool.server.entity.employee.ScPersonalInfo;
import com.yourschool.server.entity.student.ScStudent;
import com.yourschool.server.service.common.CommonService;
import com.yourschool.server.util.ScUtil;
import com.yourschool.server.vo.DocumentFor;
import com.yourschool.server.vo.EmployeeDocType;

@Service
public class ScTempUploadService {

	@Autowired
	private CommonService commonService;

	private final Path rootLocation = Paths.get("upload");

	public ScDocument store(MultipartFile file, DocumentBody documentBody, Long id) throws Exception {

		String uploadPath = System.getProperty("user.dir") + File.separator + "upload";

		String dirPath = uploadPath;

		LocalDate today = LocalDate.now();
		int year = today.getYear();
		int monthValue = today.getMonthValue();
		int dayOfMonth = today.getDayOfMonth();

		String datePath = File.separator + year + File.separator + monthValue + File.separator + dayOfMonth;

		String docFor = documentBody.getDocFor();

		if (docFor.equals(DocumentFor.EMPLOYEE))
			dirPath += File.separator + DocumentFor.EMPLOYEE + File.separator + datePath + File.separator + id;

		String filePath = dirPath + File.separator + file.getOriginalFilename();

		File dirFile = new File(dirPath);
		File fileToWrite = new File(filePath);

		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}

		if (fileToWrite.exists()) {
			fileToWrite.delete();
		}

		file.transferTo(fileToWrite);

		Long docId = documentBody.getId();
		ScDocument doc = null;
		if (ScUtil.isAllPresent(docId))
			doc = commonService.findById(docId, ScDocument.class);
		else
			doc = new ScDocument();

		doc.setName(file.getOriginalFilename());
		doc.setPath(dirPath);

		doc = commonService.save(doc);

		return doc;

	}

	public Resource loadFile(Long docId) {
		try {

			ScDocument doc = commonService.findById(docId, ScDocument.class);

			if (!ScUtil.isAllPresent(doc))
				throw new NotFoundException("Document not found");

			Path filePath = Paths.get(doc.getPath() + File.separator + doc.getName());
			Resource resource = new UrlResource(filePath.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new InternalServerException("FAIL!");
			}
		} catch (MalformedURLException e) {
			throw new InternalServerException(e.getMessage());
		}
	}

	public ActionResponse updateDocument(Long id, MultipartFile file, String documentBodyStr) {

		ActionResponse res = new ActionResponse();

		try {

			ObjectMapper objMapper = new ObjectMapper();
			DocumentBody documentBody = objMapper.readValue(documentBodyStr, DocumentBody.class);

			String docFor = documentBody.getDocFor();
			String type = documentBody.getType();
			ScDocument doc = store(file, documentBody, id);

			if (!ScUtil.isAllPresent(docFor, type))
				throw new BadRequestException("One or more field are empty in Document Body");

			if (docFor.equals(DocumentFor.EMPLOYEE))
				updateEmployeeDocs(id, docFor, type, doc);

			if (docFor.equals(DocumentFor.STUDENT))
				this.updateStudentDocs(id, docFor, type, doc);

			res.setActionMessage(doc.getId().toString());

		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}

		res.setApiMessage(ApiUtil.okMessage("Success"));

		return res;
	}

	private void updateEmployeeDocs(Long id, String docFor, String type, ScDocument doc) {
		ScEmployee employee = commonService.findById(id, ScEmployee.class);

		if (!ScUtil.isAllPresent(docFor, type))
			throw new NotFoundException("Could not update document.");

		ScPersonalInfo personalInfo = employee.getPersonalInfo();
		if (!ScUtil.isAllPresent(personalInfo)) {
			throw new InternalServerException("Could not update document.");
		}

		if (type.equals(EmployeeDocType.AADHAAR_CARD))
			personalInfo.setAadharCardDoc(doc);

		else if (type.equals(EmployeeDocType.DRIVING_LICENSE))
			personalInfo.setDrivingLicenceDoc(doc);

		else if (type.equals(EmployeeDocType.PAN_CARD))
			personalInfo.setPanCardDoc(doc);

		else if (type.equals(EmployeeDocType.PROFILE_PIC))
			employee.setProfilePic(doc);

		else if (type.equals(EmployeeDocType.VOTER_ID))
			personalInfo.setVoterIdDoc(doc);

		else if (type.equals(EmployeeDocType.X_CERT))
			personalInfo.setxCertDoc(doc);

		else if (type.equals(EmployeeDocType.XII_CERT))
			personalInfo.setxIICertDoc(doc);

		else if (type.equals(EmployeeDocType.GRADUATION_CERT))
			personalInfo.setGraduationCertDoc(doc);

		else if (type.equals(EmployeeDocType.POST_GRADUATION_CERT))
			personalInfo.setPostGraduationCertDoc(doc);

		commonService.save(employee);
	}

	private void updateStudentDocs(Long id, String docFor, String type, ScDocument doc) {

		ScStudent student = commonService.findById(id, ScStudent.class);
		student.setProfilePic(doc);
		commonService.save(student);
	}

	public void deleteAll() {
		FileSystemUtils.deleteRecursively(rootLocation.toFile());
	}

	public void init() {
		try {
			Files.createDirectory(rootLocation);
		} catch (IOException e) {
			throw new InternalServerException("Could not initialize storage!");
		}
	}
}
