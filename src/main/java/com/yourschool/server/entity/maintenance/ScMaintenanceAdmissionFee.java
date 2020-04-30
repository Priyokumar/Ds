package com.yourschool.server.entity.maintenance;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SC_MANAGE_ADMISSION_FEE")
public class ScMaintenanceAdmissionFee implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "SC_ID")
	private Long id;
	
	@Column(name = "YEAR")
	private String year;

	@Column(name = "STANDARD")
	private String standard;

	@Column(name = "FEE_AMOUNT")
	private Double feeAmount;

	@Column(name = "ADMISSION_AMOUNT")
	private Double admissionAmount;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SC_MAINT_ADM_FEE_YEARLY_ID")
	private ScMaintenanceAdmissionFeeYearly maintenanceAdmissionFeeYearly;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public ScMaintenanceAdmissionFeeYearly getMaintenanceAdmissionFeeYearly() {
		return maintenanceAdmissionFeeYearly;
	}

	public void setMaintenanceAdmissionFeeYearly(ScMaintenanceAdmissionFeeYearly maintenanceAdmissionFeeYearly) {
		this.maintenanceAdmissionFeeYearly = maintenanceAdmissionFeeYearly;
	}
	
	

}
