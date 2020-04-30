package com.yourschool.server.entity.maintenance;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "SC_MANAGE_ADMISSION_FEE_YEARLY")
public class ScMaintenanceAdmissionFeeYearly implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "SC_ID")
	private Long id;
	
	@Column(name = "YEAR")
	private String year;
	
	@OneToMany(targetEntity = ScMaintenanceAdmissionFee.class, cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "SC_MAINT_ADM_FEE_YEARLY_ID", referencedColumnName = "SC_ID")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<ScMaintenanceAdmissionFee> maintenanceAdmissionFees = new ArrayList<>();

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

	public List<ScMaintenanceAdmissionFee> getMaintenanceAdmissionFees() {
		return maintenanceAdmissionFees;
	}

	public void setMaintenanceAdmissionFees(List<ScMaintenanceAdmissionFee> maintenanceAdmissionFees) {
		this.maintenanceAdmissionFees = maintenanceAdmissionFees;
	}
	
	
}
