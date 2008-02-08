package net.springsocial.context;


/**
 * Interface to be implemented by any object that wishes to be notified of
 * the {@link FacebookConfiguration} for the application that it runs in.
 * 
 * @author Scott Rossillo
 *
 */
public interface FacebookContextAware {
	
	/**
	 * Sets the Facebook configuration for this bean.
	 * 
	 * @param facebookConfiguration the <code>FacebookConfiguration</code>
	 * from this bean's application context
	 */
	public void setFacebookConfiguration(FacebookConfiguration facebookConfiguration);

}
