package net.springsocial.context.facebook;

import java.util.List;

import com.facebook.api.Facebook;

/**
 * Provides a Facebook request context.
 * 
 * @author Scott Rossillo
 *
 */
public interface FacebookRequestContext {
	
	public Facebook getFacebook();
	public void setFacebook(Facebook facebook);

	/**
	 * Returns true if the current user has added this application.
	 * 
	 * @return <code>true</code> if the current user has added this 
	 * application; <code>false</code> otherwise
	 */
	public boolean isApplicationAdded();

	/**
	 * Returns the browser request method, typically an HTTP GET or POST.
	 * Facebook always POSTs to applications but relays the actual browser
	 * request method to the application.
	 * 
	 * @return the HTTP request method invoked by the client's browser
	 * to Facebook's server
	 */
	public String getBrowserRequestMethod();
	
	public void setBrowserRequestMethod(String method);

	/**
	 * Returns the uid of the user invoking this request
	 * 
	 * @return the <code>uid</code> of the user invoking this request
	 */
	public Long getUid();

	/**
	 * Returns a list containing the uid's of the current users friends
	 * 
	 * @return a <code>List</code> containing the <code>uid</code>s of the
	 * current user's friends
	 */
	public List<Long> getFriendUids();
	
	/**
	 * Sets the uids of friends of the the current user.
	 *  
	 * @param friendUids a <code>List</code> of people the current user
	 * is friends with
	 * 
	 */
	public void setFriendUids(List<Long> friendUids);

}