package it.univpm.SpringBootApplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidBodyException extends Exception{
	

	private static final long serialVersionUID = 1L;

	public InvalidBodyException(String msg) {
		super();
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, msg);
	}
		
}
