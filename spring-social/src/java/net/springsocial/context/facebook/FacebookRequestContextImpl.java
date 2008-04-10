package net.springsocial.context.facebook;

import java.util.List;

import com.facebook.api.Facebook;

/**
 * Provides a Facebook request context implementation.
 * 
 * @author Scott Rossillo
 *
 */
public class FacebookRequestContextImpl implements FacebookRequestContext {
		
	private boolean applicationAdded;
	private String browserRequestMethod;
	
	private Long uid;
	private List<Long> friendUids;
	
	private boolean inCanvas;
	private Facebook facebook;
	
	/**
	 * Creates a new Facebook request context. 
	 */
	public FacebookRequestContextImpl() { }
	
	
	/* (non-Javadoc)
	 * @see net.springsocial.context.facebook.FacebookRequestContext#getFacebook()
	 */
	public Facebook getFacebook() {
		return facebook;
	}
	
	/* (non-Javadoc)
	 * @see net.springsocial.context.facebook.FacebookRequestContext#setFacebook(com.facebook.api.Facebook)
	 */
	public void setFacebook(Facebook facebook) {
		this.facebook = facebook;
		
		this.setUid(facebook.getUser());
		this.setApplicationAdded(facebook.isAdded());
	}

	/* (non-Javadoc)
	 * @see net.springsocial.context.facebook.FacebookRequestContext#isApplicationAdded()
	 */
	public boolean isApplicationAdded() {
		return applicationAdded;
	}

	/* (non-Javadoc)
	 * @see net.springsocial.context.facebook.FacebookRequestContext#getBrowserRequestMethod()
	 */
	public String getBrowserRequestMethod() {
		return browserRequestMethod;
	}

	/* (non-Javadoc)
	 * @see net.springsocial.context.facebook.FacebookRequestContext#getUid()
	 */
	public Long getUid() {
		return uid;
	}


	/* (non-Javadoc)
	 * @see net.springsocial.context.facebook.FacebookRequestContext#getFriendUids()
	 */
	public List<Long> getFriendUids() {
		return friendUids;
	}

	/* (non-Javadoc)
	 * @see net.springsocial.context.facebook.FacebookRequestContext#isInCanvas()
	 */
	public boolean isInCanvas() {
		return inCanvas;
	}

	/**
	 * @param applicationAdded
	 */
	private void setApplicationAdded(boolean applicationAdded) {
		this.applicationAdded = applicationAdded;
	}


	public void setBrowserRequestMethod(String browserRequestMethod) {
		this.browserRequestMethod = browserRequestMethod;
	}

	private void setUid(Long uid) {
		this.uid = uid;
	}

	/* (non-Javadoc)
	 * @see net.springsocial.context.facebook.FacebookRequestContext#setFriendUids(java.util.List)
	 */
	public void setFriendUids(List<Long> friendUids) {
		this.friendUids = friendUids;
	}

}
