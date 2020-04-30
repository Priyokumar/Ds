package com.yourschool.server.entity.employee;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.yourschool.server.entity.user.ScUser;

@Embeddable
public class ScRecordAudit implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name = "created_By")
	private ScUser createdBy;

	@Column(name = "UPDATED_BY")
	private ScUser updatedBy;

	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "UPDATED_DATE")
	private Date updatedDate;

	public ScUser getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(ScUser createdBy) {
		this.createdBy = createdBy;
	}

	public ScUser getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(ScUser updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
