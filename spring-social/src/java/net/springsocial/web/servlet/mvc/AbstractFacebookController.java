package net.springsocial.web.servlet.mvc;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.springsocial.context.FacebookConfiguration;
import net.springsocial.context.FacebookContextAware;
import net.springsocial.web.servlet.http.FacebookHttpServletRequest;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.facebook.api.FacebookRestClient;

/**
 * Provides an abstract Facebook controller.
 * 
 * @author Scott Rossillo
 *
 */
public abstract class AbstractFacebookController extends AbstractController
		implements FacebookContextAware, FacebookController {
	
	protected FacebookConfiguration facebookConfiguration;
	protected boolean requireFacebookSession;
	
	
	public AbstractFacebookController() {
		this.requireFacebookSession = false;
	}
	
	private FacebookRestClient doPreHandle(
			FacebookHttpServletRequest request) throws ServletException {
		
		FacebookRestClient facebookClient =
			(FacebookRestClient) request.getAttribute("facebookClient");
		
		if(this.isRequireFacebookSession()) {
			FacebookToolkit.requireSession(request);
		}
        
		return facebookClient;
	}
	
	
	/**
	 * Returns the Facebook API key for this controller's application.
	 * 
	 * @return the Facebook API key for this controller.
	 */
	protected String getApiKey() {
		return facebookConfiguration.getApiKey();
	}
	
	/**
	 * Handles Facebook requests, delegating to 
	 * {@link #handleRequestInternal(HttpServletRequest, HttpServletResponse, FacebookRestClient)}
	 * do the actual work.
	 * 
	 * @see org.springframework.web.servlet.mvc.AbstractController#handleRequestInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected final ModelAndView handleRequestInternal(
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		FacebookRestClient facebookRestClient = this.doPreHandle( (FacebookHttpServletRequest) request);
		
		return this.handleRequestInternal( (FacebookHttpServletRequest) request, response, facebookRestClient);
	}
	
	
	/**
	 * @param request
	 * @param response
	 * @param facebookRestClient
	 * @return
	 * @throws Exception
	 */
	protected abstract ModelAndView handleRequestInternal(
			FacebookHttpServletRequest request,
			HttpServletResponse response,
			FacebookRestClient facebookRestClient) throws Exception;


	/* (non-Javadoc)
	 * @see net.rossillo.spring.context.support.FacebookContextAware#setFacebookConfiguration(net.rossillo.spring.context.support.FacebookConfiguration)
	 */
	public void setFacebookConfiguration(FacebookConfiguration facebookConfiguration) {

		this.facebookConfiguration = facebookConfiguration;
	}

	/* (non-Javadoc)
	 * @see net.rossillo.spring.web.servlet.mvc.FacebookController#isRequireFacebookSession()
	 */
	public boolean isRequireFacebookSession() {
		return requireFacebookSession;
	}

	/* (non-Javadoc)
	 * @see net.rossillo.spring.web.servlet.mvc.FacebookController#setRequireFacebookSession(boolean)
	 */
	public void setRequireFacebookSession(boolean requireFacebookSession) {
		this.requireFacebookSession = requireFacebookSession;
	}
	
}
