package net.springsocial.web.servlet.mvc;


import com.facebook.api.FacebookRestClient;

import net.springsocial.context.support.FacebookSessionException;
import net.springsocial.web.servlet.http.FacebookHttpServletRequest;

/**
 * Provides common controller utility methods necessary since 
 * Facebook controllers easily share a super class.
 * 
 * @author Scott Rossillo
 *
 */
final class FacebookToolkit {
	
	/**
	 * Returns the Facebook rest client for the given request.
	 * 
	 * @param request
	 * @return
	 */
	public static FacebookRestClient getClient(FacebookHttpServletRequest request) {
		
		return (FacebookRestClient) request.getAttribute("facebookClient");
	}
	
	public static void requireSession(FacebookHttpServletRequest request) throws FacebookSessionException {
		
		String authToken = request.getAuthToken();
		String sessionKey = request.getSessionKey();
		
		if(authToken == null && sessionKey == null) {
			throw new FacebookSessionException("Facebook session not found!");
		}
		
	}
	

	private FacebookToolkit() { }
}
