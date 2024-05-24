package com.root.main.models;

import org.springframework.http.HttpStatus;

public class ResponseMessage {

	private HttpStatus status;
	private String Message;
	
	public ResponseMessage() {
		
	}

	public ResponseMessage(HttpStatus status, String message) {
		super();
		this.status = status;
		Message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

}
