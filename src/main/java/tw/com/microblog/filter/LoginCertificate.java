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

//防止直接拜訪 Servlet

//@WebFilter(urlPatterns = { "/search_MessageServlet", "/del_MessageServlet", "/new_MesssgeServlet", "/loginOutServlet",
//		"/edit_MessageServlet" })
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
//			response.sendRedirect("/WEB-INF/views/login.jsp");
//			
//		} else {
//
//			chain.doFilter(request, response);
//		}
//	}
//
//	public void init(FilterConfig fConfig) throws ServletException {
//	}
//
//}
