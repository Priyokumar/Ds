package com.yourschool.server.entity.employee;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "SC_EMPLOYEE_ATTENDENCE")
public class ScEmployeeAttendence implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "SC_ID")
	private Long id;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "DAY")
	private String day;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATE")
	private Date date;
	
	@Column(name = "TIMEIN")
	private String timeIn;
	
	@Column(name = "timeOut")
	private String timeOut;
	
	@Column(name = "TOTAL")
	private String total;
	
	@Column(name = "COMMENT")
	private String comment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTimeIn() {
		return timeIn;
	}

	public void setTimeIn(String timeIn) {
		this.timeIn = timeIn;
	}

	public String getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(String timeOut) {
		this.timeOut = timeOut;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
