package com.qsp.Bank_Management_System.exception;

public class CardIdNotFound extends RuntimeException {

	private String message = "Card id not found in DB";

	public String getMessage() {

		return message;

	}

}
