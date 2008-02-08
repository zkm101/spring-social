package net.springsocial.web.servlet.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.springsocial.web.servlet.http.FacebookHttpServletRequest;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractFormController;

/**
 * Provides an extensible form controller.
 * 
 * @author Scott Rossillo
 *
 */
public abstract class AbstractFacebookFormController extends AbstractFormController 
		implements FacebookController {
	
	private boolean requireFacebookSession;

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.AbstractFormController#isFormSubmission(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	protected boolean isFormSubmission(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return super.isFormSubmission(request);
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

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.AbstractFormController#processFormSubmission(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.validation.BindException)
	 */
	@Override
	protected final ModelAndView processFormSubmission(
			HttpServletRequest request,
			HttpServletResponse response, 
			Object command, 
			BindException errors)
			throws Exception {
		
		return processFormSubmission( (FacebookHttpServletRequest) request, response, command, errors);
	}
	
	/**
	 * @param request
	 * @param response
	 * @param command
	 * @param ex
	 * @return
	 * @throws Exception
	 */
	protected abstract ModelAndView processFormSubmission(
			FacebookHttpServletRequest request,
			HttpServletResponse response, 
			Object command, 
			BindException errors)
			throws Exception;
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.AbstractFormController#showForm(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.springframework.validation.BindException)
	 */
	@Override
	protected final ModelAndView showForm(
			HttpServletRequest request,
			HttpServletResponse response, 
			BindException errors) throws Exception {
		
		
		return showForm( (FacebookHttpServletRequest) request, response, errors);
	}

	/**
	 * @param request the current Facebook HTTP request
	 * @param response the current HTTP response
	 * @param errors validation errors holder
	 * 
	 * @return the prepared model and view
	 * 
	 * @throws Exception
	 */
	protected abstract ModelAndView showForm(
			FacebookHttpServletRequest request,
			HttpServletResponse response, 
			BindException errors) throws Exception;
}
