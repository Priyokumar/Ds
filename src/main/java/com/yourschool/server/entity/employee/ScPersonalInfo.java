package com.yourschool.server.entity.employee;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.yourschool.server.entity.ScDocument;

@Entity
@Table(name = "SC_PERSONAL_INFO")
public class ScPersonalInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SC_ID")
	private Long id;

	@Column(name = "PAN_CARD")
	private String panCard;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "PAN_CARD_DOC")
	private ScDocument panCardDoc;

	@Column(name = "AADHAR_CARD")
	private String aadharCard;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "AADHAR_CARD_DOC")
	private ScDocument aadharCardDoc;

	@Column(name = "VOTER_ID")
	private String voterId;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "VOTER_ID_DOC")
	private ScDocument voterIdDoc;

	@Column(name = "DRIVING_LICENCE")
	private String drivingLicence;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "DRIVING_LICENCE_DOC")
	private ScDocument drivingLicenceDoc;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "X_CERT_DOC")
	private ScDocument xCertDoc;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "XII_CERT_DOC")
	private ScDocument xIICertDoc;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "GRAD_CERT_DOC")
	private ScDocument graduationCertDoc;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "POST_GRAD_CERT_DOC")
	private ScDocument postGraduationCertDoc;

	@OneToOne(cascade = CascadeType.ALL)
	@MapsId
	private ScEmployee personalInfoEmployee;

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

	public String getDrivingLicence() {
		return drivingLicence;
	}

	public void setDrivingLicence(String drivingLicence) {
		this.drivingLicence = drivingLicence;
	}

	public ScEmployee getPersonalInfoEmployee() {
		return personalInfoEmployee;
	}

	public void setPersonalInfoEmployee(ScEmployee personalInfoEmployee) {
		this.personalInfoEmployee = personalInfoEmployee;
	}

	public String getVoterId() {
		return voterId;
	}

	public void setVoterId(String voterId) {
		this.voterId = voterId;
	}

	public ScDocument getPanCardDoc() {
		return panCardDoc;
	}

	public void setPanCardDoc(ScDocument panCardDoc) {
		this.panCardDoc = panCardDoc;
	}

	public ScDocument getAadharCardDoc() {
		return aadharCardDoc;
	}

	public void setAadharCardDoc(ScDocument aadharCardDoc) {
		this.aadharCardDoc = aadharCardDoc;
	}

	public ScDocument getVoterIdDoc() {
		return voterIdDoc;
	}

	public void setVoterIdDoc(ScDocument voterIdDoc) {
		this.voterIdDoc = voterIdDoc;
	}

	public ScDocument getDrivingLicenceDoc() {
		return drivingLicenceDoc;
	}

	public void setDrivingLicenceDoc(ScDocument drivingLicenceDoc) {
		this.drivingLicenceDoc = drivingLicenceDoc;
	}

	public ScDocument getxCertDoc() {
		return xCertDoc;
	}

	public void setxCertDoc(ScDocument xCertDoc) {
		this.xCertDoc = xCertDoc;
	}

	public ScDocument getxIICertDoc() {
		return xIICertDoc;
	}

	public void setxIICertDoc(ScDocument xIICertDoc) {
		this.xIICertDoc = xIICertDoc;
	}

	public ScDocument getGraduationCertDoc() {
		return graduationCertDoc;
	}

	public void setGraduationCertDoc(ScDocument graduationCertDoc) {
		this.graduationCertDoc = graduationCertDoc;
	}

	public ScDocument getPostGraduationCertDoc() {
		return postGraduationCertDoc;
	}

	public void setPostGraduationCertDoc(ScDocument postGraduationCertDoc) {
		this.postGraduationCertDoc = postGraduationCertDoc;
	}
	

}
