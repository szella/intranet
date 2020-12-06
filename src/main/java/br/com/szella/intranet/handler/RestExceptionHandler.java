package br.com.szella.intranet.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.szella.intranet.exception.BadRequestException;
import br.com.szella.intranet.exception.BadRequestExceptionDetails;

@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<BadRequestExceptionDetails> handlerBadRequestException(BadRequestException bre) {
		return new ResponseEntity<BadRequestExceptionDetails>(
				BadRequestExceptionDetails.builder().timestamp(LocalDateTime.now())
						.status(HttpStatus.BAD_REQUEST.value()).title("Bad Request Exception, Check the Documentation")
						.details(bre.getMessage()).developerMessage(bre.getClass().getName()).build(),
				HttpStatus.BAD_REQUEST);
	}

}
