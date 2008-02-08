package net.springsocial.web.servlet.mvc;

/**
 * Provides the base interface representing controllers designed to participate
 * in an MVC workflow and process <code>FacebookHttpServletRequest</code>s.
 * 
 * <p>
 * Facebook controllers extend the functionality of Spring MVC controllers to
 * handle Facebook application specific requests.  Facebook requests differ from
 * standard HTTP requests in that they are always initiated by Facebook, not a
 * client's web browser.
 * </p>
 *  
 * @author Scott Rossillo
 *
 */
public interface FacebookController {

	/**
	 * Returns true if this controller requires a Facebook session.
	 * 
	 * @return <code>true</code> if this controller requires a facebook session;
	 * <code>false</code> otherwise.
	 */
	public abstract boolean isRequireFacebookSession();

	/**
	 * Sets whether or not this controller requires a Facebook session.
	 * 
	 * @param requireFacebookSession <code>true</code> to require a Facebook
	 * session; <code>false</code> otherwise
	 */
	public abstract void setRequireFacebookSession(
			boolean requireFacebookSession);

}