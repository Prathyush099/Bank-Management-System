package com.qsp.Bank_Management_System.exception;

public class BankIdNotFound extends RuntimeException {

	private String message = "Bank id not found in DB";

	public String getMessage() {
		return message;
	}
}
