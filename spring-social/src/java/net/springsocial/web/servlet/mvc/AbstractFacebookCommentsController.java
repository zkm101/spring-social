package net.springsocial.web.servlet.mvc;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.springsocial.context.support.FacebookCommentsModel;
import net.springsocial.web.servlet.http.FacebookHttpServletRequest;
import net.springsocial.web.servlet.view.FacebookCommentsCallbackView;

import org.springframework.web.servlet.ModelAndView;

import com.facebook.api.FacebookRestClient;

/**
 * @author scott
 *
 */
public abstract  class AbstractFacebookCommentsController extends AbstractFacebookController {
	
	private String formView;
	
	protected abstract FacebookCommentsModel createCommentsModel(FacebookHttpServletRequest request);
	
	public AbstractFacebookCommentsController() {
		super();
		super.setRequireFacebookSession(true);
	}
	
	@Override
	protected final ModelAndView handleRequestInternal(
			FacebookHttpServletRequest request, HttpServletResponse response,
			FacebookRestClient facebookRestClient) throws Exception {
		
		ModelAndView mav;
		
		if(!isFormSubmission(request)) {
			mav = showForm(request, response, facebookRestClient);
		} else {
			mav = processFormSubmission(request, response);
		}
		
		return mav;
	}
	
	/**
	 * Returns true if the given request is a form submission.
	 * 
	 * @param request
	 * @return <code>true</code> if the give <code>request</code> is a form
	 * submission; <code>false</code> otherwise
	 */
	protected boolean isFormSubmission(FacebookHttpServletRequest request) {
		return request.getXid() != null;
	}
	
	/**
	 * Returns reference data for the form view.
	 * 
	 * Subclasses may override this method to provide
	 * extra model data. 
	 * 
	 * This implementation returns <code>null</cod>.
	 * 
	 * @param request the current HTTP request
	 * 
	 * @param facebookRestClient the authenticated Facebook client for the
	 * given <code>request</code>
	 *  
	 * @return a <code>Map</code> containing model reference data for a 
	 * form view
	 * 
	 * @throws Exception if an error occurs
	 */
	protected Map<String,Object> referenceData(
			FacebookHttpServletRequest request,
			FacebookRestClient facebookRestClient) throws Exception {
		
		
		return null;
	}
	
	/**
	 * Returns a model and view for the comments form.
	 * 
	 * @param request the current HTTP request
	 * 
	 * @param response the current HTTP response
	 * 
	 * @param facebookRestClient the <code>FacebookRestClient</code> for the given
	 * request
	 * 
	 * @return the comments form <code>ModelAndView</code>
	 * 
	 * @throws Exception if an error occurs
	 */
	protected ModelAndView showForm(
			FacebookHttpServletRequest request, HttpServletResponse response,
			FacebookRestClient facebookRestClient) throws Exception {
		
		FacebookCommentsModel commentsModel = this.createCommentsModel(request);
		ModelAndView mav = new ModelAndView(this.getFormView());
		Map<String,Object> data = this.referenceData(request, facebookRestClient);
		
		mav.addObject("comments", commentsModel);
		
		if(data != null) {
			mav.addAllObjects(data);
		}
		
		
		return mav;
	}
	
	/**
	 * Processes a comments form submission be only returning the comments
	 * FBML necessary for Facebook to handle comment posting.
	 * 
	 * @param request the current HTTP request
	 * @param response the current HTTP response
	 * 
	 * @return
	 * 
	 * @throws Exception if an error occurs
	 */
	protected final ModelAndView processFormSubmission(
			FacebookHttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		FacebookCommentsModel commentsModel = this.createCommentsModel(request);
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("comments", commentsModel);
		mav.setView(new FacebookCommentsCallbackView());
		
		return mav;
	}

	/**
	 * Returns the name of the form view.
	 * 
	 * @return the name of the form view
	 */
	public String getFormView() {
		return formView;
	}

	/**
	 * Sets the name of the form view for this controller.
	 * 
	 * @param formView the name of the form view
	 */
	public void setFormView(String formView) {
		this.formView = formView;
	}

}
