package com.bank.Exception;

import java.util.Date;

public class ErrorDetails {
	private Date time;
	private String message;
	private String details;
	public ErrorDetails(Date time, String message, String details) {
		super();
		this.time = time;
		this.message = message;
		this.details = details;
	}
	
	
}
