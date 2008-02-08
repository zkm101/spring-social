package net.springsocial.web.servlet.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.springsocial.web.servlet.http.FacebookHttpServletRequest;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/** 
 * Abstract adapter class for the FacebookHandlerInterceptor interface, 
 * for simplified implementation of pre-only/post-only interceptors.
 * 
 * @author Scott Rossillo
 *
 */
public abstract class FacebookHandlerInterceptorAdapter implements HandlerInterceptor, FacebookHandlerInterceptor {

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	public final void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		afterCompletion( (FacebookHttpServletRequest) request, response, handler, ex);
	}
	
	/**
	 * This implementation is empty.
	 * 
	 * @see net.springsocial.web.servlet.handler.FacebookHandlerInterceptor#afterCompletion(net.springsocial.web.servlet.http.FacebookHttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	public void afterCompletion(FacebookHttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		// does nothing
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	public final void postHandle(
			HttpServletRequest request, 
			HttpServletResponse response,
			Object handler, 
			ModelAndView mav) throws Exception {
	
		postHandle( (FacebookHttpServletRequest) request, response, handler, mav);
	}
	
	/**
	 * This implementation is empty.
	 * 
	 * @see net.springsocial.web.servlet.handler.FacebookHandlerInterceptor#postHandle(net.springsocial.web.servlet.http.FacebookHttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	public void postHandle(
			FacebookHttpServletRequest request, 
			HttpServletResponse response,
			Object handler, 
			ModelAndView mav) throws Exception {
		
		// does nothing
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	public final boolean preHandle(
			HttpServletRequest request, 
			HttpServletResponse response,
			Object handler) throws Exception {
		
		return preHandle( (FacebookHttpServletRequest) request, response, handler);
	}
	
	/**
	 * This implementation always returns <code>true</code>.
	 * 
	 * @see net.springsocial.web.servlet.handler.FacebookHandlerInterceptor#preHandle(net.springsocial.web.servlet.http.FacebookHttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	public boolean preHandle(
			FacebookHttpServletRequest request, 
			HttpServletResponse response,
			Object handler) throws Exception {
		
		return true;
	}

}
