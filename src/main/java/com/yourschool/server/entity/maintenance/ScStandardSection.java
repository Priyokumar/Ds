package com.yourschool.server.entity.maintenance;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SC_STANDARD_SECTION")
public class ScStandardSection implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "SC_ID")
	private Long id;
	
	@Column(name = "NAME")
	private String name;

	@Column(name = "DESCRIPTION")
	private String description;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "STANDARD_ID")
	private ScStandard standard;

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

	public ScStandard getStandard() {
		return standard;
	}

	public void setStandard(ScStandard standard) {
		this.standard = standard;
	}
	
	

}
