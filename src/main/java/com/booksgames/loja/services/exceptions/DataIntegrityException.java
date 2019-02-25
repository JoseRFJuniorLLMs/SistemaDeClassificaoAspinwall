package com.booksgames.loja.services.exceptions;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 15 02 2019
 */

public class DataIntegrityException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public DataIntegrityException(String msg) {
		super(msg);
	}
	public DataIntegrityException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
