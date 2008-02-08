package net.springsocial.web.servlet.http;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Provides an HTTP servlet request wrapper for Facebook requests to
 * facilitate access to Facebook specific request information.
 * 
 * @author Scott Rossillo
 *
 */
public class FacebookHttpServletRequest extends HttpServletRequestWrapper {
	
	private final static Log log = LogFactory.getLog(FacebookHttpServletRequest.class);

	private final boolean applicationAdded;
	private final String browserRequestMethod;
	
	private final String apiKey;
	private final String authToken;
	private final String sessionKey;
	
	private final Long sessionKeyExpirationTime;
	private final Long userProfileLastUpdateTime;
	
	private final String xid;
	private final Long uid;
	private final List<Long> friendUids;
	
	private final boolean inCanvas;
	
	/**
	 * Constructs a new Facebook request wrapper for the given request.
	 * 
	 * @param request the <code>HttpServletRequest</code> to wrap
	 */
	public FacebookHttpServletRequest(HttpServletRequest request) {
		
		super(request);
		
		apiKey = request.getParameter("fb_sig_api_key");
		authToken = request.getParameter("auth_token");
		sessionKey = request.getParameter("fb_sig_session_key");
		sessionKeyExpirationTime = longValue(request.getParameter("fb_sig_expires"));
		
		applicationAdded = !"0".equals(request.getParameter("fb_sig_added")) ? true : false;
		browserRequestMethod = request.getParameter("fb_sig_request_method");
		
		uid = longValue(request.getParameter("fb_sig_user"));
		userProfileLastUpdateTime = longValue(request.getParameter("fb_sig_profile_update_time"));
		friendUids = longListValue(request.getParameter("fb_sig_friends"));
		
		inCanvas = !"0".equals(request.getParameter("fb_sig_in_canvas"));
		
		xid = request.getParameter("fb_sig_xid");
		
		if(log.isDebugEnabled()) {
			log.debug("User [" + uid + "] has [" + friendUids.size() + "] friends");
		}
	}
	
	/**
	 * Returns the Long equivalent of the given string or null if the given string is null.
	 */
	private Long longValue(String value) {
		
		return (value != null ? new Long(value) : null);
	}
	
	/**
	 * Returns a list of longs from the given string (assumes comma delimited input).
	 */
	private List<Long> longListValue(String value) {
		
		List<Long> list = new LinkedList<Long>();
		
		if(value == null) {
			return list;	
		}
		
		String[] parts = value.split(",");
		
		for(String part : parts) {
			list.add(new Long(part));
		}
		
		return list;
	}


	/**
	 * Returns the API key provided by Facebook for this request.
	 * 
	 * @return the API key provided by Facebook for this request
	 */
	public String getApiKey() {
		return apiKey;
	}

	/**
	 * Returns the auth token for this request.
	 * 
	 * @return the auth token for this request
	 */
	public String getAuthToken() {
		return authToken;
	}


	/**
	 * The session key for this request.
	 * 
	 * @return the session key for this request
	 */
	public String getSessionKey() {
		return sessionKey;
	}


	public Long getSessionKeyExpirationTime() {
		return sessionKeyExpirationTime;
	}

	/**
	 * Returns true if the current user has added this application.
	 * 
	 * @return <code>true</code> if the current user has added this 
	 * application; <code>false</code> otherwise
	 */
	public boolean isApplicationAdded() {
		return applicationAdded;
	}


	/**
	 * Returns the browser request method, typically an HTTP GET or POST.
	 * Facebook always POSTs to applications but relays the actual browser
	 * request method to the application.
	 * 
	 * @return the HTTP request method invoked by the client's browser
	 * to Facebook's server
	 */
	public String getBrowserRequestMethod() {
		return browserRequestMethod;
	}


	/**
	 * Returns the comments unique identifier for this request.
	 * 
	 * @return the unique comments <code>xid</code> for this request 
	 */
	public String getXid() {
		return xid;
	}


	/**
	 * Returns the uid of the user invoking this request
	 * 
	 * @return the <code>uid</code> of the user invoking this request
	 */
	public Long getUid() {
		return uid;
	}


	/**
	 * Returns a list containing the uid's of the current users friends
	 * 
	 * @return a <code>List</code> containing the <code>uid</code>s of the
	 * current user's friends
	 */
	public List<Long> getFriendUids() {
		return friendUids;
	}

	/**
	 * Returns the last update time of the current user's profile.
	 * 
	 * @return the last update time - in milliseconds since epoch - of
	 * the current user's profile
	 */
	public Long getUserProfileLastUpdateTime() {
		return userProfileLastUpdateTime;
	}

	/**
	 * Returns true if this is a canvas page request.
	 * 
	 * @return <code>true</code> if this is a canvas page request;
	 * <code>false</code> otherwise
	 */
	public boolean isInCanvas() {
		return inCanvas;
	}
	
}
