package com.yourschool.server.dto.error;

public class ApiErrorException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private int code;

	private String detail;

	private String status;

	public ApiErrorException(int code, String detail, String status) {
		super(detail);
		this.code = code;
		this.detail = detail;
		this.status = status;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
