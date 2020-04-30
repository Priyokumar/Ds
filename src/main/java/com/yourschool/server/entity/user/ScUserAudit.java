package com.yourschool.server.entity.user;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SC_USER_AUDIT")
public class ScUserAudit implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "SC_ID")
	private Long id;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID")
	private ScUser user;

	@Column(name = "ACTION_TYPE")
	private String actionType;

	@Column(name = "ACTION")
	private String action;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ACTION_DATE")
	private Date actionDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ScUser getUser() {
		return user;
	}

	public void setUser(ScUser user) {
		this.user = user;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Date getActionDate() {
		return actionDate;
	}

	public void setActionDate(Date actionDate) {
		this.actionDate = actionDate;
	}

}
