package com.booksgames.loja.services.exceptions;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 15 02 2019
 */

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public ObjectNotFoundException(String msg) {
		super(msg);
	}
	public ObjectNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
