package net.springsocial.web.servlet.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.springsocial.context.FacebookConfiguration;
import net.springsocial.context.FacebookContextAware;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

/**
 * Provides a mapping exception resolver that exposes the Facebook configuration
 * to error views.
 * 
 * @author Scott Rossillo
 *
 */
public class ViewMappingExceptionResolver 
		extends SimpleMappingExceptionResolver 
		implements FacebookContextAware {

	protected FacebookConfiguration facebookConfiguration;
	
	/**
	 * Resolves exceptions using the super classes
	 * {@link #doResolveException(HttpServletRequest, HttpServletResponse, Object, Exception)}
	 * method and adds Facebook configuration data to the returned 
	 * model and view.
	 * 
	 * @see org.springframework.web.servlet.handler.SimpleMappingExceptionResolver#doResolveException(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	@Override
	protected ModelAndView doResolveException(
			HttpServletRequest request,
			HttpServletResponse response, 
			Object handler, Exception ex) {
		
		ModelAndView mav =  super.doResolveException(request, response, handler, ex);
		
		if(mav != null) {
			mav.addObject("apiKey", facebookConfiguration.getApiKey());
			mav.addObject("canvasPageUrl", facebookConfiguration.getCanvasPageUrl());
			mav.addObject("callbackUrl", facebookConfiguration.getCallbackUrl());
			mav.addObject("googleAnalyticsAccountId", facebookConfiguration.getGoogleAnalyticsAccountId());
		}
		
		return mav;
	}

	/* (non-Javadoc)
	 * @see net.rossillo.spring.context.support.FacebookContextAware#setFacebookConfiguration(net.rossillo.spring.context.support.FacebookConfiguration)
	 */
	public void setFacebookConfiguration(
			FacebookConfiguration facebookConfiguration) {
		
		this.facebookConfiguration = facebookConfiguration;
	}

}
