package com.anz.exception;

/**
 * the ParammeterException
 * 
 * @author jesse
 * @since 1.0
 */
@SuppressWarnings("serial")
public class ParammeterException extends Exception {

	/**
	 * Create an ParammeterException with a specific message and cause
	 * 
	 * @param message
	 * @param cause
	 */
	public ParammeterException(String message, Exception cause) {
		super(message, cause);
	}

	/**
	 * Create an ParammeterException with a specific message
	 * 
	 * @param message
	 */
	public ParammeterException(String message) {
		super(message);
	}
}
