package com.qsp.Bank_Management_System.exception;

public class AddressIdNotFound extends RuntimeException {

	private String message = "Address id not found in DB";

	public String getMessage() {

		return message;
	}
}
