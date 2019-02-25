package com.booksgames.loja.services.exceptions;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 15 02 2019
 */

public class FileException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public FileException(String msg) {
		super(msg);
	}
	public FileException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
