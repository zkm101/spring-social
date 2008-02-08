package net.springsocial.web.servlet.handler;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.AbstractView;

public class FBMLFacebookSessionExceptionResolver extends
		AbstractFacebookSessionExceptionResolver {

	/**
	 * Returns a view that renders a Facebook mark-up language redirect.
	 * 
	 * @see net.springsocial.web.servlet.handler.AbstractFacebookSessionExceptionResolver#resolveExceptionView(java.lang.Exception)
	 */
	@Override
	protected View resolveExceptionView(Exception ex) {
		
		return new AbstractView() {

			@SuppressWarnings("unchecked")
			@Override
			protected void renderMergedOutputModel(Map model,
					HttpServletRequest request, HttpServletResponse response)
					throws Exception {
				
				String url = 
					"http://www.facebook.com/login.php?api_key=" + facebookConfiguration.getApiKey() + "&v=1.0&canvas=true";
				
				response.getWriter().println("<fb:redirect url='" + url + "' />");
			}
			
		};
	}

}
