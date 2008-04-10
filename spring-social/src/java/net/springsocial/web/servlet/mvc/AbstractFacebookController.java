package net.springsocial.web.servlet.mvc;


import net.springsocial.context.FacebookConfiguration;

import org.springframework.web.servlet.mvc.AbstractController;

/**
 * Provides an abstract Facebook controller.
 * 
 * @author Scott Rossillo
 *
 */
public abstract class AbstractFacebookController extends AbstractController implements FacebookController {
	
	protected FacebookConfiguration facebookConfiguration;
	protected boolean requireFacebookSession;
	
	
	public AbstractFacebookController() {
		this.requireFacebookSession = false;
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
