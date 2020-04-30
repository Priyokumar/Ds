package com.yourschool.server.dto.maintenance;

import java.util.ArrayList;
import java.util.List;

public class Standard {

	private Long id;

	private String name;

	private String description;

	private List<StandardSection> sections = new ArrayList<>();

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

	public List<StandardSection> getSections() {
		return sections;
	}

	public void setSections(List<StandardSection> sections) {
		this.sections = sections;
	}
	
	

}
