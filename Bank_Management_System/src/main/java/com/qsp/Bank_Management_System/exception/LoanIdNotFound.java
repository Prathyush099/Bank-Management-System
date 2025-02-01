package com.qsp.Bank_Management_System.exception;

public class LoanIdNotFound extends RuntimeException {

	private String message = "Loan id not found in DB";

	public String getMessage() {

		return message;

	}
}
