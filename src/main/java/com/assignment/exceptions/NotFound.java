package com.assignment.exceptions;

public class NotFound extends RuntimeException{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	boolean success;
	public NotFound(boolean success) {
		super(String.format("Resource not found:%s",success));
		this.success=success;
	}

}
