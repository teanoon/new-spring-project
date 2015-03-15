package com.player.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( value = HttpStatus.NOT_FOUND )
public class HttpNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3100719662778840734L;
}
