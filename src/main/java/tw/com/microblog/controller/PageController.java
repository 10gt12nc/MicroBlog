package tw.com.microblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {

	@RequestMapping("/home")
	public String home() {

		System.out.println("home");
		return "home"; // home.jsp
	}

	@RequestMapping(value = "/homeG", method = RequestMethod.GET)
	public String homeForGet() {

		System.out.println("homeG");
		return "home"; //
	}

	// http://brianchen85.blogspot.com/2017/01/java-jsp-ajax-controller.html

	@RequestMapping("/register")
	public String register() {

		System.out.println("register~~~~");
		return "register";
	}

	@RequestMapping("/login")
	public String login() {

		System.out.println("login~~~~");
		return "login";
	}

	@RequestMapping("/member") // 無值 只是頁面轉跳
	public String member() {

		System.out.println("member~~~~");
		return "member";
	}

	@RequestMapping(value = "/editMessage", params = { "id", "message" })
	public String editMessage() {

		System.out.println("edit_message");
		return "edit_message";
	}

	@RequestMapping("/forgetpass") // 無值 只是頁面轉跳
	public String forgetpass() {

		System.out.println("forgetpass~~~~");
		return "forgetpass";
	}

	@RequestMapping("/retrieve_pass")
	public String retrieve_pass() {

		System.out.println("retrieve_pass~~~~");
		return "retrieve_pass";
	}

}
