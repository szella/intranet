package br.com.szella.intranet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {
	private static final long serialVersionUID = 4947181716871362613L;

	public BadRequestException(String message) {
		super(message);
	}

}
