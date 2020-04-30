package com.yourschool.server.dto.maintenance;

public class MaintenanceAdmissionFee {

	private Long id;
	
	private String year;

	private String standard;

	private Double feeAmount;

	private Double admissionAmount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getFeeAmount() {
		return feeAmount;
	}

	public void setFeeAmount(Double feeAmount) {
		this.feeAmount = feeAmount;
	}

	public Double getAdmissionAmount() {
		return admissionAmount;
	}

	public void setAdmissionAmount(Double admissionAmount) {
		this.admissionAmount = admissionAmount;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
}
