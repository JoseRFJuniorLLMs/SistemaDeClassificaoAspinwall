package com.booksgames.loja.services.exceptions;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 15 02 2019
 */

public class AuthorizationException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public AuthorizationException(String msg) {
		super(msg);
	}
	public AuthorizationException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
