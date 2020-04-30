package com.yourschool.server.dto;

public class DocumentBody {
	
	private Long id;
	
	private String docFor;
	
	private String type;
	
	private String name;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDocFor() {
		return docFor;
	}

	public void setDocFor(String docFor) {
		this.docFor = docFor;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
