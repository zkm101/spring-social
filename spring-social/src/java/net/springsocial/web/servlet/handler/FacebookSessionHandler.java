package net.springsocial.web.servlet.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.springsocial.context.FacebookConfiguration;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.facebook.api.FacebookRestClient;

/**
 * Provides a Facebook application handler to pre and post handle
 * all Facebook requests.
 * 
 * @author Scott Rossillo
 * 
 * @deprecated Use {@link FacebookRequestContextHandler} instead
 *
 */
public final class FacebookSessionHandler extends HandlerInterceptorAdapter  {

	private FacebookConfiguration facebookConfiguration;
	
	/**
	 * Exposes this Facebook application's configuration via the given model and view.
	 * 
	 * Specifically the following configuration elements are exposed:
	 * 
	 * <ul>
	 * 	<li>apiKey</li>
	 *  <li>canvasPageUrl</li>
	 *  <li>callbackUrl</li>
	 *  <li>googleAnalyticsAccountId</li>
	 * </ul>
	 * 
	 * @see net.springsocial.web.servlet.handler.FacebookHandlerInterceptorAdapter#postHandle(net.springsocial.web.servlet.http.FacebookHttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler, ModelAndView mav)
			throws Exception {
		
		mav.addObject("apiKey", facebookConfiguration.getApiKey());
		mav.addObject("canvasPageUrl", facebookConfiguration.getCanvasPageUrl());
		mav.addObject("callbackUrl", facebookConfiguration.getCallbackUrl());
		mav.addObject("googleAnalyticsAccountId", facebookConfiguration.getGoogleAnalyticsAccountId());
	}

	/**
	 * Provides a Facebook rest client to the given request.
	 * 
	 * @see net.springsocial.web.servlet.handler.FacebookHandlerInterceptorAdapter#preHandle(net.springsocial.web.servlet.http.FacebookHttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
	
		String apiKey = facebookConfiguration.getApiKey();
		String apiSecret = facebookConfiguration.getSecret();
		
		String authToken = null; //request.getAuthToken();
		String sessionKey = null; // request.getSessionKey();
		
		FacebookRestClient facebookClient = null;
		
        if (sessionKey != null) {
        	//System.err.println("GOT A SESSION KEY " + sessionKey);
        	facebookClient = new FacebookRestClient(apiKey, apiSecret, sessionKey);
        } else {
        	//System.err.println("DONT HAVE A SESSION KEY, AUTH KEY IS " + authToken);
        	facebookClient = new FacebookRestClient(apiKey, apiSecret);
        	if(authToken != null) {
        		facebookClient.auth_getSession(authToken);
        	}
        }

        facebookClient.setIsDesktop(facebookConfiguration.isDesktop());
		
        request.setAttribute("facebookClient", facebookClient);
		
		return true;
	}

	/* (non-Javadoc)
	 * @see net.rossillo.spring.context.support.FacebookContextAware#setFacebookConfiguration(net.rossillo.spring.context.support.FacebookConfiguration)
	 */
	public void setFacebookConfiguration(
			FacebookConfiguration facebookConfiguration) {

		this.facebookConfiguration = facebookConfiguration;
	}
	
	

}
