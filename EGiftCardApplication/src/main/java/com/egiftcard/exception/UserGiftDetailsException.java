package com.egiftcard.exception;

import org.springframework.http.HttpStatus;

public class UserGiftDetailsException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HttpStatus status;

	public UserGiftDetailsException() {
		super();
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public UserGiftDetailsException(HttpStatus status) {
		super();
		this.status = status;
	}

	public UserGiftDetailsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public UserGiftDetailsException(String message, Throwable cause) {
		super(message, cause);

	}

	public UserGiftDetailsException(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}

	public UserGiftDetailsException(Throwable cause) {
		super(cause);

	}

}
