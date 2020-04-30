package com.yourschool.server.entity.employee;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SC_EMPLOYEE_HISTORY")
public class ScEmployeeHistory implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "SC_ID")
	private Long id;

	@Column(name = "EMPLOYER_NAME")
	private String employerName;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "START_DATE")
	private Date startDate;

	@Column(name = "END_DATE")
	private Date endDate;

	@Column(name = "DESIGNATION")
	private String designation;

	@OneToOne(cascade = CascadeType.ALL)
	@MapsId
	private ScEmployee lastEmployeeHistoryEmployee;

	/*
	 * @ManyToOne(fetch = FetchType.EAGER)
	 * 
	 * @JoinColumn(name = "EMPLOYEE_ID") private ScEmployee employee;
	 */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmployerName() {
		return employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public ScEmployee getLastEmployeeHistoryEmployee() {
		return lastEmployeeHistoryEmployee;
	}

	public void setLastEmployeeHistoryEmployee(ScEmployee lastEmployeeHistoryEmployee) {
		this.lastEmployeeHistoryEmployee = lastEmployeeHistoryEmployee;
	}

}
