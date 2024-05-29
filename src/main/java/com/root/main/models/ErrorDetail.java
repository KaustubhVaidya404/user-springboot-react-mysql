package com.root.main.models;

import org.springframework.http.HttpStatus;

public class ErrorDetail {

	private String message;
	private HttpStatus status;
	
	public ErrorDetail() {
	
	}
	
	public ErrorDetail(String message, HttpStatus status) {
		super();
		this.message = message;
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}	
}
