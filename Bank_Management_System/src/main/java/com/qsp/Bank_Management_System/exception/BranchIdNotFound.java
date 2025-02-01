package com.qsp.Bank_Management_System.exception;

public class BranchIdNotFound extends RuntimeException {

	private String message = "Branch id not found in DB";

	public String getMessage() {

		return message;
	}
}
