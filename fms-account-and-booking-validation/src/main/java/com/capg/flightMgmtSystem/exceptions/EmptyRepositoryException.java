package com.capg.flightMgmtSystem.exceptions;

public class EmptyRepositoryException extends Exception{

	private static final long serialVersionUID = 1L;

	public EmptyRepositoryException(String message) {
		super(message);
	}
	
	@Override
	public String toString() {
		String message=super.getMessage();
		return " "+message;
	}
}

