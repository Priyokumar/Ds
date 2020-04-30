package com.yourschool.server.dto.employee;

public class AcademicBackground {

	private Long id;

	private String name;

	private String board;

	private String schoolInstitue;

	private String startYear;

	private String passOutYear;

	private String score;

	private Boolean highestQualification;

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

	public String getStartYear() {
		return startYear;
	}

	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}

	public String getPassOutYear() {
		return passOutYear;
	}

	public void setPassOutYear(String passOutYear) {
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

}
