package net.springsocial.sample.facebook.web.servlet.mvc;

import javax.servlet.http.HttpServletResponse;

import net.springsocial.web.servlet.http.FacebookHttpServletRequest;
import net.springsocial.web.servlet.mvc.AbstractFacebookController;

import org.springframework.web.servlet.ModelAndView;

import com.facebook.api.FacebookRestClient;

/**
 * Provides a sample welcome controller.
 * 
 * @author Scott Rossillo
 *
 */
public class WelcomeController extends AbstractFacebookController {

	@Override
	protected ModelAndView handleRequestInternal(FacebookHttpServletRequest request,
			HttpServletResponse response, FacebookRestClient facebookRestClient)
			throws Exception {
	
		ModelAndView mav = new ModelAndView("welcome");
		
		mav.addObject("welcomeMessage", "Welcome to the sample Spring Facebook application!");
		
		mav.addObject("userMessage", request.isApplicationAdded() ?
				"We're glad you're using our application." 
				: "We'd love for you to add this application!");
		
		return mav;
		
	}
	
}
