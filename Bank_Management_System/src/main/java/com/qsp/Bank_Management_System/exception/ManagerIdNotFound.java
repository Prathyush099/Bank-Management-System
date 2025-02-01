package com.qsp.Bank_Management_System.exception;

public class ManagerIdNotFound extends RuntimeException{
	
	private String message = "Manager id not found in DB";

	public String getMessage() {

		return message;

	}

}
