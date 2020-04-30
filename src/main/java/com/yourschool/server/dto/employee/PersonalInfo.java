package com.yourschool.server.dto.employee;

import com.yourschool.server.dto.Document;

public class PersonalInfo {

	private Long id;

	private String panCard;
	
	private Document panCardDoc;

	private String aadharCard;
	
	private Document aadharCardDoc;

	private String voterId;
	
	private Document voterIdDoc;

	private String drivingLicence;
	
	private Document drivingLicenceDoc;
	
	private Document xCertDoc;
	
	private Document xIICertDoc;
	
	private Document graduationCertDoc;
	
	private Document postGraduationCertDoc;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPanCard() {
		return panCard;
	}

	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}

	public String getAadharCard() {
		return aadharCard;
	}

	public void setAadharCard(String aadharCard) {
		this.aadharCard = aadharCard;
	}

	public String getVoterId() {
		return voterId;
	}

	public void setVoterId(String voterId) {
		this.voterId = voterId;
	}

	public String getDrivingLicence() {
		return drivingLicence;
	}

	public void setDrivingLicence(String drivingLicence) {
		this.drivingLicence = drivingLicence;
	}

	public Document getPanCardDoc() {
		return panCardDoc;
	}

	public void setPanCardDoc(Document panCardDoc) {
		this.panCardDoc = panCardDoc;
	}

	public Document getAadharCardDoc() {
		return aadharCardDoc;
	}

	public void setAadharCardDoc(Document aadharCardDoc) {
		this.aadharCardDoc = aadharCardDoc;
	}

	public Document getVoterIdDoc() {
		return voterIdDoc;
	}

	public void setVoterIdDoc(Document voterIdDoc) {
		this.voterIdDoc = voterIdDoc;
	}

	public Document getDrivingLicenceDoc() {
		return drivingLicenceDoc;
	}

	public void setDrivingLicenceDoc(Document drivingLicenceDoc) {
		this.drivingLicenceDoc = drivingLicenceDoc;
	}

	public Document getxCertDoc() {
		return xCertDoc;
	}

	public void setxCertDoc(Document xCertDoc) {
		this.xCertDoc = xCertDoc;
	}

	public Document getxIICertDoc() {
		return xIICertDoc;
	}

	public void setxIICertDoc(Document xIICertDoc) {
		this.xIICertDoc = xIICertDoc;
	}

	public Document getGraduationCertDoc() {
		return graduationCertDoc;
	}

	public void setGraduationCertDoc(Document graduationCertDoc) {
		this.graduationCertDoc = graduationCertDoc;
	}

	public Document getPostGraduationCertDoc() {
		return postGraduationCertDoc;
	}

	public void setPostGraduationCertDoc(Document postGraduationCertDoc) {
		this.postGraduationCertDoc = postGraduationCertDoc;
	}
	
}
