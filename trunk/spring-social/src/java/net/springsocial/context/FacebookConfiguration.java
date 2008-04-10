package net.springsocial.context;


import java.io.Serializable;

import org.springframework.beans.factory.annotation.Required;

/**
 * Provides a Facebook application configuration bean intended for use inside
 * a web application context.
 * 
 * This bean is required for any kind of usage of the Spring Facebook API.
 *
 *
 * @author Scott Rossillo
 *
 */
public class FacebookConfiguration implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String apiKey;
	private String secret;
	
	private String callbackUrl;
	private String applicationUri;
	
	private String canvasPageUrl;
	
	private boolean desktop;
	
	private String googleAnalyticsAccountId;
	
	/**
	 * Creates a new Facebook application configuration.
	 */
	public FacebookConfiguration() { 
		this.setDesktop(false);
	}

	/**
	 * Return the application's Facebook API key.
	 * 
	 * @return the API key for this application
	 */
	public String getApiKey() {
		return apiKey;
	}

	/**
	 * Sets the Facebook API key for this application.
	 * 
	 * @param apiKey the Facebook provided API key for this application
	 */
	@Required
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	/**
	 * Returns the Facebook secret for this application.
	 * 
	 * @return the Facebook secret for this application
	 */
	public String getSecret() {
		return secret;
	}

	/**
	 * Sets the Facebook secret for this application
	 * 
	 * @param secret the Facebook provided secret for this application
	 */
	@Required
	public void setSecret(String secret) {
		this.secret = secret;
	}

	/**
	 * Returns the callback URL for this application.
	 * 
	 * @return the callback URL for this application
	 */
	public String getCallbackUrl() {
		return callbackUrl;
	}

	/**
	 * Sets the callback URL for this application.
	 * 
	 * @param callbackUrl the callback URL for this application
	 */
	@Required
	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}

	/**
	 * Returns this application's URI.
	 * 
	 * @return this application's URI
	 */
	public String getApplicationUri() {
		return applicationUri;
	}

	/**
	 * Sets the URI for this application
	 * 
	 * @param applicationUri the URI for this application
	 */
	@Required
	public void setApplicationUri(String applicationUri) {
		this.applicationUri = applicationUri;
		this.canvasPageUrl = "http://apps.facebook.com/" + applicationUri;
	}
	
	/**
	 * Returns the canvas page URL for this application.
	 * 
	 * @return the canvas page URL for this application
	 */
	public String getCanvasPageUrl() {
		return this.canvasPageUrl;
	}

	/**
	 * Returns true if this application is a desktop application.
	 * 
	 * @return <code>true</code> if this application is a desktop
	 * application; <code>false</code> otherwise
	 */
	public boolean isDesktop() {
		return desktop;
	}

	/**
	 * Sets whether or not this is a desktop application.
	 * 
	 * @param desktop <code>true</code> if this is a desktop application;
	 * <code>false</code> otherwise
	 */
	public void setDesktop(boolean desktop) {
		this.desktop = desktop;
	}

	
	/**
	 * Returns the Google Analytics account identifier for this application
	 * 
	 * @return the Google Analytics accoutn id for this application if 
	 * specified; <code>null</code> otherwise
	 */
	public String getGoogleAnalyticsAccountId() {
		return googleAnalyticsAccountId;
	}

	/**
	 * Sets the Google analytics account identifier for this application.
	 * 
	 * @param googleAnalyticsAccountId the Google provided analytics account
	 * identifier for this application
	 */
	public void setGoogleAnalyticsAccountId(String googleAnalyticsAccountId) {
		this.googleAnalyticsAccountId = googleAnalyticsAccountId;
	}

}
