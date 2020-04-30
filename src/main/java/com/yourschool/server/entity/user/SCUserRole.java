package com.yourschool.server.entity.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SC_USER_ROLE")
public class SCUserRole implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "SC_ID")
	private int id;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ROLE_ID")
	private ScRole role;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID")
	private ScUser user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ScRole getRole() {
		return role;
	}

	public void setRole(ScRole role) {
		this.role = role;
	}

	public ScUser getUser() {
		return user;
	}

	public void setUser(ScUser user) {
		this.user = user;
	}

}
