package com.qsp.Bank_Management_System.exception;

public class CustomerIdNotFound extends RuntimeException{
	
	private String message = "Customer id not found in DB";

	public String getMessage() {

		return message;
	}

}
