package net.springsocial.web.servlet.mvc;

import javax.servlet.http.HttpServletRequest;

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
	public boolean isFacebookSessionRequired() {
		return requireFacebookSession;
	}

	/* (non-Javadoc)
	 * @see net.rossillo.spring.web.servlet.mvc.FacebookController#setRequireFacebookSession(boolean)
	 */
	public void setFacebookSessionRequired(boolean requireFacebookSession) {
		this.requireFacebookSession = requireFacebookSession;
	}

}
