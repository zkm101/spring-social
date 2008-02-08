package net.springsocial.web.servlet.mvc;

import javax.servlet.http.HttpServletResponse;

import junit.framework.TestCase;

import net.springsocial.web.servlet.http.FacebookHttpServletRequest;
import net.springsocial.web.servlet.mvc.SimpleFacebookCommentsController;
import net.springsocial.web.servlet.view.FacebookCommentsCallbackView;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

/**
 * Provides test cases for the simple comments controller.
 * 
 * @author Scott Rossillo
 *
 */
public class SimpleFacebookCommentsControllerTest extends TestCase {

	private MockHttpServletRequest request;
	
	public void setUp() {
		
		request = new MockHttpServletRequest("POST", "/foo");
		
		request.setParameter("fb_sig_added", "1");
		request.setParameter("fb_sig_session_key", "123");
	
	}
	
	public void testCommentsView() throws Exception {
		
		SimpleFacebookCommentsController controller = new SimpleFacebookCommentsController();
		HttpServletResponse response = new MockHttpServletResponse();
		
		controller.setFormView("foo");
		ModelAndView mav = controller.handleRequest(new FacebookHttpServletRequest(request), response); 
		
		assertEquals("foo", mav.getViewName());
	}
	
	public void testCommentsXidCallback() throws Exception {
		
		SimpleFacebookCommentsController controller = new SimpleFacebookCommentsController();
		HttpServletResponse response = new MockHttpServletResponse();
		
		request.setParameter("fb_sig_xid", "abc_123");
		
		ModelAndView mav = controller.handleRequest(new FacebookHttpServletRequest(request), response); 
		
		assertEquals(FacebookCommentsCallbackView.class, mav.getView().getClass());
	}
	
	
}
