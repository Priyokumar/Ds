package com.yourschool.server.dto.maintenance;

import java.util.ArrayList;
import java.util.List;

public class MaintenanceAdmissionFeeYearly {

	private Long id;
	
	private String year;
	
	private List<MaintenanceAdmissionFee> maintenanceAdmissionFees = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public List<MaintenanceAdmissionFee> getMaintenanceAdmissionFees() {
		return maintenanceAdmissionFees;
	}

	public void setMaintenanceAdmissionFees(List<MaintenanceAdmissionFee> maintenanceAdmissionFees) {
		this.maintenanceAdmissionFees = maintenanceAdmissionFees;
	}
	
}
