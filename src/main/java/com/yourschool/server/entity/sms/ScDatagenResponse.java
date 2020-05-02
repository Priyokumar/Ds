package com.yourschool.server.entity.sms;


public class ScDatagenResponse {

	private String status;
	
	private  int totalnumbers_sbmited;
	
	private long campg_id;
	
	private String logid;
	
	private String code;
	
	private String ts;
	
	private String desc;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTotalnumbers_sbmited() {
		return totalnumbers_sbmited;
	}

	public void setTotalnumbers_sbmited(int totalnumbers_sbmited) {
		this.totalnumbers_sbmited = totalnumbers_sbmited;
	}

	public long getCampg_id() {
		return campg_id;
	}

	public void setCampg_id(long campg_id) {
		this.campg_id = campg_id;
	}

	public String getLogid() {
		return logid;
	}

	public void setLogid(String logid) {
		this.logid = logid;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "ScDatagenResponse [status=" + status + ", totalnumbers_sbmited=" + totalnumbers_sbmited + ", campg_id="
				+ campg_id + ", logid=" + logid + ", code=" + code + ", ts=" + ts + ", desc=" + desc + "]";
	}
	
	
	
}
