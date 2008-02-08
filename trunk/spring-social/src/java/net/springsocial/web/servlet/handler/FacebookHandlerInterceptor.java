package net.springsocial.web.servlet.handler;

import javax.servlet.http.HttpServletResponse;

import net.springsocial.web.servlet.http.FacebookHttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * 
 * 
 * @author Scott Rossillo
 *
 */
public interface FacebookHandlerInterceptor {

	/**
	 * Called after completion of request processing, that is, after rendering the view. 
	 * Will be called on any outcome of handler execution, thus allows for proper resource cleanup.
	 * 
	 * <p>
	 * Note: Will only be called if this interceptor's <code>preHandle</code> method has 
	 * successfully completed and returned <code>true</code>.
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @param handler
	 * @param ex
	 * @throws Exception
	 */
	public abstract void afterCompletion(FacebookHttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception;

	/**
	 * Intercept the execution of a handler. 
	 * Called after HandlerAdapter actually invoked the handler, but before 
	 * the DispatcherServlet renders the view. Can expose additional model 
	 * objects to the view via the given ModelAndView.
	 * 
	 * <p>With this method, each interceptor can post-process an execution, 
	 * getting applied in inverse order of the execution chain.</p>
	 * 
	 * @param request
	 * @param response
	 * @param handler
	 * @param mav
	 * @throws Exception
	 */
	public abstract void postHandle(FacebookHttpServletRequest request,
			HttpServletResponse response, Object handler, ModelAndView mav)
			throws Exception;

	/**
	 * Intercept the execution of a handler. 
	 * Called after HandlerMapping determined an appropriate handler object, 
	 * but before HandlerAdapter invokes the handler.
	 * 
	 * <p>
	 * DispatcherServlet processes a handler in an execution chain, consisting of 
	 * any number of interceptors, with the handler itself at the end. With this 
	 * method, each interceptor can decide to abort the execution chain, 
	 * typically sending a HTTP error or writing a custom response.
	 * 
	 * 
	 * @param request
	 * @param response the current HTTP response
	 * @param handler chosen handler to execute, for type and/or instance evaluation
	 * 
	 * @return <code>true</code> if the execution chain should proceed with the next 
	 * interceptor or the handler itself; <code>false</code> if this interceptor has
	 * already dealt with the response itself
	 * 
	 * @throws Exception if an error occurs
	 */
	public abstract boolean preHandle(FacebookHttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception;

}