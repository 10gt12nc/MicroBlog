package tw.com.microblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	
	@RequestMapping("/home") 
	public String hello() {

		System.out.println("hi~~~~");
		return "home"; // home.jsp
	}
	// http://brianchen85.blogspot.com/2017/01/java-jsp-ajax-controller.html
	
	
	
	
	@RequestMapping("/register") 
	public String register() {

		System.out.println("register~~~~");
		return "register"; 
	}
	
	
}
