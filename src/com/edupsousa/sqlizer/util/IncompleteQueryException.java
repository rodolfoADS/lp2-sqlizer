package com.edupsousa.sqlizer.util;

public class IncompleteQueryException extends RuntimeException {

	private String message;
	
	public IncompleteQueryException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}
}
