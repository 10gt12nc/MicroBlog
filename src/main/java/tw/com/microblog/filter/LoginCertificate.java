package tw.com.microblog.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//
//@WebFilter(urlPatterns = { "/search_Message", "/member.jsp", "/del_Message", "/new_Messsge", "/loginOut",
//		"/edit_message.jsp", "/edit_Message" })
//public class LoginCertificate implements Filter {
//
//	public LoginCertificate() {
//	}
//
//	public void destroy() {
//	}
//
//	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
//			throws IOException, ServletException {
//
//		HttpServletRequest request = (HttpServletRequest) req;
//		HttpServletResponse response = (HttpServletResponse) res;
//
//		if (request.getSession().getAttribute("login") == null) {
//			response.sendRedirect("login.jsp");
//		} else {
//			chain.doFilter(request, response);
//		}
//	}
//
//	public void init(FilterConfig fConfig) throws ServletException {
//	}
//
//}
