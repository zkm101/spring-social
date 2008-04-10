package net.springsocial.web.servlet.handler;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.springsocial.context.FacebookConfiguration;
import net.springsocial.context.facebook.FacebookRequestContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.facebook.api.Facebook;

/**
 * Provides a Facebook request context handler.
 * 
 * @author Scott Rossillo
 *
 */
public class FacebookRequestContextHandler extends HandlerInterceptorAdapter implements HandlerInterceptor {
 	
	private final static Log log = LogFactory.getLog(FacebookRequestContextHandler.class);
	
	/**
	 * Returns a list of longs from the given string (assumes comma delimited input).
	 */
	private static List<Long> longListValue(String value) {
		
		List<Long> list = new LinkedList<Long>();
		
		if(value == null) { return list; }
		
		String[] parts = value.split(",");
		for(String part : parts) { list.add(new Long(part)); }
		
		return list;
	}


	private FacebookConfiguration facebookConfiguration;
	private FacebookRequestContext facebookRequestContext;
	
	/**
	 * Exposes this Facebook application's configuration to the given model.
	 * 
	 * The following configuration elements are exposed:
	 * 
	 * <ul>
	 * 	<li>apiKey</li>
	 *  <li>canvasPageUrl</li>
	 *  <li>callbackUrl</li>
	 *  <li>googleAnalyticsAccountId</li>
	 * </ul>
	 * 
	 */
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler, ModelAndView mav)
			throws Exception {
		
		mav.addObject("apiKey", facebookConfiguration.getApiKey());
		mav.addObject("canvasPageUrl", facebookConfiguration.getCanvasPageUrl());
		mav.addObject("callbackUrl", facebookConfiguration.getCallbackUrl());
		mav.addObject("googleAnalyticsAccountId", facebookConfiguration.getGoogleAnalyticsAccountId());
		
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	public boolean preHandle(
			HttpServletRequest request,
			HttpServletResponse response,
			Object obj) throws Exception {
		
		if(log.isDebugEnabled()) {
			log.debug("Handling request [" + request.getRequestURI() + "]");
		}
		
		Facebook facebook = new Facebook(
				request, response, 
				facebookConfiguration.getApiKey(), facebookConfiguration.getSecret());
		
		facebookRequestContext.setFacebook(facebook);
		
		if(!facebook.isLogin()) {
			log.warn("User not logged in to application, redirecting.");
			facebook.requireLogin(request.getRequestURL().toString());
			return false;
		}
		
		facebookRequestContext.setFriendUids(longListValue(request.getParameter("fb_sig_friends")));
		facebookRequestContext.setBrowserRequestMethod(request.getParameter("fb_sig_request_method"));
		
		return true;
	}

	/**
	 * Sets the Facebook request context for this handler.
	 * 
	 * @param facebookRequestContext the <code>FacebookRequestContext</code>
	 * this handler will manage
	 */
	@Autowired
	public void setFacebookRequestContext(
			FacebookRequestContext facebookRequestContext) {
		this.facebookRequestContext = facebookRequestContext;
	}

	
	/**
	 * Sets the Facebook configuration for this handler.
	 * 
	 * @param facebookConfiguration the current <code>FacebookConfiguration</code>
	 */
	@Autowired
	public void setFacebookConfiguration(
			FacebookConfiguration facebookConfiguration) {
		this.facebookConfiguration = facebookConfiguration;
	}

}
