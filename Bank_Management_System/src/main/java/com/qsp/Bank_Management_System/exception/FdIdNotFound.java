package com.qsp.Bank_Management_System.exception;

public class FdIdNotFound extends RuntimeException {

	private String message = "FixedDeposit id not found in DB";

	public String getMessage() {

		return message;
	}
}
