package com.qsp.Bank_Management_System.exception;

public class EmployeeIdNotFound extends RuntimeException {

	private String message = "Employee id not found in DB";

	public String getMessage() {

		return message;

	}

}
