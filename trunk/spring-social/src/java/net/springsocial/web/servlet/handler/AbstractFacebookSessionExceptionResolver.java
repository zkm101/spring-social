package net.springsocial.web.servlet.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.springsocial.context.FacebookConfiguration;
import net.springsocial.context.FacebookContextAware;
import net.springsocial.context.support.FacebookSessionException;

import org.springframework.core.Ordered;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.facebook.api.FacebookException;

/**
 * 
 * @author scott
 *
 */
public abstract class AbstractFacebookSessionExceptionResolver implements
		HandlerExceptionResolver, FacebookContextAware, Ordered {

	protected FacebookConfiguration facebookConfiguration;
	private int order;
	
	
	/* (non-Javadoc)
	 * @see org.springframework.core.Ordered#getOrder()
	 */
	public int getOrder() {
		return order;
	}
	
	/**
	 * @param order
	 * 
	 * @see #getOrder()
	 */
	public void setOrder(int order) {
		this.order = order;
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerExceptionResolver#resolveException(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		
		if((ex instanceof FacebookSessionException) || (ex instanceof FacebookException)) {
			return this.resolveException(ex);
		}
		
		return null;
	}
	
	/**
	 * @param ex
	 * @return
	 */
	protected final ModelAndView resolveException(Exception ex) {

		ModelAndView mav = new ModelAndView();
		mav.setView(resolveExceptionView(ex));
		
		return mav;
	}
	
	/**
	 * @param ex
	 * @return
	 */
	protected abstract View resolveExceptionView(Exception ex);

	/* (non-Javadoc)
	 * @see net.rossillo.spring.context.support.FacebookContextAware#setFacebookConfiguration(net.rossillo.spring.context.support.FacebookConfiguration)
	 */
	public void setFacebookConfiguration(FacebookConfiguration facebookConfiguration) {
		
		this.facebookConfiguration = facebookConfiguration;
		
	}

}
