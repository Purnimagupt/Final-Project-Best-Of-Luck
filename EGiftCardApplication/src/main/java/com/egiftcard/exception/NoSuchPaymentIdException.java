package com.egiftcard.exception;

public class NoSuchPaymentIdException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSuchPaymentIdException(String message) {
		super(message);
	}
}
