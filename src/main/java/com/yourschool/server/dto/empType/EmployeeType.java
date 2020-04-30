package com.yourschool.server.dto.empType;

import java.util.ArrayList;
import java.util.List;

public class EmployeeType {

	private Long id;

	private String name;

	private String description;

	private List<Designation> designations = new ArrayList<>();

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Designation> getDesignations() {
		return designations;
	}

	public void setDesignations(List<Designation> designations) {
		this.designations = designations;
	}
	
	
}
