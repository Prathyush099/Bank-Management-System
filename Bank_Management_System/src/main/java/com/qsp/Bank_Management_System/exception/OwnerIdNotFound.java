package com.qsp.Bank_Management_System.exception;

public class OwnerIdNotFound extends RuntimeException {

	private String message = "Owner id not found in DB";

	public String getMessage() {

		return message;

	}

}
