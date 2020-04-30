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
@Table(name = "SC_ACADEMIC_BACKGROUND")
public class ScAcademicBackground implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "SC_ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "BOARD")
	private String board;

	@Column(name = "SCHOOL_INSTITUE")
	private String schoolInstitue;

	@Column(name = "START_YEAR")
	private Date startYear;

	@Column(name = "PASS_OUT_YEAR")
	private Date passOutYear;

	@Column(name = "SCORE")
	private String score;

	@Column(name = "HIGHEST_QUALIFICATION")
	private Boolean highestQualification;

	@OneToOne(cascade = CascadeType.ALL)
	@MapsId
	private ScEmployee highestQualificationEmployee;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBoard() {
		return board;
	}

	public void setBoard(String board) {
		this.board = board;
	}

	public String getSchoolInstitue() {
		return schoolInstitue;
	}

	public void setSchoolInstitue(String schoolInstitue) {
		this.schoolInstitue = schoolInstitue;
	}

	public Date getPassOutYear() {
		return passOutYear;
	}

	public void setPassOutYear(Date passOutYear) {
		this.passOutYear = passOutYear;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public Boolean getHighestQualification() {
		return highestQualification;
	}

	public void setHighestQualification(Boolean highestQualification) {
		this.highestQualification = highestQualification;
	}

	public ScEmployee getHighestQualificationEmployee() {
		return highestQualificationEmployee;
	}

	public void setHighestQualificationEmployee(ScEmployee highestQualificationEmployee) {
		this.highestQualificationEmployee = highestQualificationEmployee;
	}

	public Date getStartYear() {
		return startYear;
	}

	public void setStartYear(Date startYear) {
		this.startYear = startYear;
	}

}
