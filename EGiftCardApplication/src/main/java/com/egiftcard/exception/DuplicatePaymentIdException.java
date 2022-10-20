package com.egiftcard.exception;

public class DuplicatePaymentIdException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicatePaymentIdException(String message) {
		super(message);
	}
}
