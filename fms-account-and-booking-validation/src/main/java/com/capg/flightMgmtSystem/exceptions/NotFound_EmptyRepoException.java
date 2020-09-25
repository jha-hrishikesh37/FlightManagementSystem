package com.capg.flightMgmtSystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFound_EmptyRepoException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public NotFound_EmptyRepoException(String message){
        super(message);
    }
	
	@Override
	public String toString() {
		String message=super.getMessage();
		return " "+message;
	}
}
