package net.springsocial.context.support;

import javax.servlet.ServletException;

public class FacebookSessionException extends ServletException {
	
	private static final long serialVersionUID = 1L;

	public FacebookSessionException(String message, Throwable rootCause) {
		super(message, rootCause);
		// TODO Auto-generated constructor stub
	}

	public FacebookSessionException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public FacebookSessionException(Throwable rootCause) {
		super(rootCause);
		// TODO Auto-generated constructor stub
	}

}
