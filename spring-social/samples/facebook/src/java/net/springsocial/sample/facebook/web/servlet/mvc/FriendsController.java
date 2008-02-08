package net.springsocial.sample.facebook.web.servlet.mvc;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import net.springsocial.web.servlet.http.FacebookHttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FriendsController {
	
	@ModelAttribute("friends")
	public Collection<Long> getFriends(HttpServletRequest request) {
		
		FacebookHttpServletRequest fbRequest = (FacebookHttpServletRequest) request;
		
		return fbRequest.getFriendUids();
	}
	
	@RequestMapping
	public String handleRequest() {
		return "friends";
	}
	

}
