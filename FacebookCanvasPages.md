# Introduction #

All Facebook applications that display content on a canvas (the area of a Facebook page dedicated to your application) share a similar request model.  Under most circumstances, your application does not directly process user requests.  Instead, Facebook generates the requests to your application and handles the actual content rendering back to the client.

# Anatomy of a Canvas Page Request #

![http://images.rossillo.net/spring-facebook/Facebook_Request_Anatomy.png](http://images.rossillo.net/spring-facebook/Facebook_Request_Anatomy.png)

Canvas page request workflow:
  1. A user accesses your application via a call to your canvas page
  1. Facebook translates the request into a POST to your application's callback URL
  1. Your application may optionally make calls to Facebook's server to obtain information or store data
  1. Your application returns text containing both FBML and/or HTML which Facebook's server parses
  1. HTML is returned to the client containing the content of your applications response after all FBML tags have been parsed

**Note:**   This example assumes your application's callback URL is http://www.example.com/my-facebook-app/ and your canvas page URL http://apps.facebook.com/myapp/.


1. The user enters the URL to your application http://apps.facebook.com/myapp/somePage.html into their web browser.

2. Facebook receives this request and makes an HTTP POST to your callback URL, translating everything after your canvas page URL into the request URL to your server.  In this example, the request to your server will become http://www.example.com/my-facebook-app/somePage.html.

3. Your application (optionally) makes HTTP requests back to Facebook's servers to obtain information or store data.  These requests are accomplished using a Facebook API client.  The MVC controllers in this project expose a ready to use client to you.

4. Your server returns a view (just HTML and optionally FBML) on the servlet response to Facebook.

5. Facebook parses any FBML tags in the response body and then renders the view back to the client's web browser.

## See Also ##
  * [Spring's Web MVC Workflow](http://static.springframework.org/spring/docs/2.5.x/reference/mvc.html#mvc-servlet)
  * [Facebook Authentication Guide](http://wiki.developers.facebook.com/index.php/Authentication_guide)