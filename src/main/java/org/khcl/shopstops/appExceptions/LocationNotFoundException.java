package org.khcl.shopstops.appExceptions;

/*
 * Exception to be thrown if location is not found by google api
 * */
public class LocationNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public LocationNotFoundException(String message) {
		super(message);
	}
	
	
}
