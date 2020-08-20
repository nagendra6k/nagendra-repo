package com.techfynder.forex.exchange.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class AccessRestrictedException extends RuntimeException {

	private static final long serialVersionUID = 8716983591433865361L;

	public AccessRestrictedException(String exception) {
		super(exception);
	}

}
