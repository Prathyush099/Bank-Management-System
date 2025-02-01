package com.qsp.Bank_Management_System.exception;

public class AccountIdNotFound extends RuntimeException {

	private String message = "Account id not found in DB";

	public String getMessage() {

		return message;
	}
}
