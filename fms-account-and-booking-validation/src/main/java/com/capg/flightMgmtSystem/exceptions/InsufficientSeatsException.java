package com.capg.flightMgmtSystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class InsufficientSeatsException extends Exception {

		private static final long serialVersionUID = 1L;
		
		public InsufficientSeatsException(String message){
	        super(message);
	    }
		
		@Override
		public String toString() {
			String message=super.getMessage();
			return " "+message;
		}
}
