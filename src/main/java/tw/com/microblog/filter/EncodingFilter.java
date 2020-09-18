package tw.com.microblog.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class EncodingFilter extends HttpFilter {

	public EncodingFilter() {
	}

	public void destroy() {
	}

//	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
//
//		HttpServletRequest request=(HttpServletRequest) req;
//		HttpServletResponse response=(HttpServletResponse) res;
//		
//		request.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html;charset=UTF-8");
//		
//		chain.doFilter(request, response);
//		
//		}

//	String UTF8;

	@Override
	public void init() throws ServletException {

//		UTF8 = getFilterConfig().getInitParameter("UTF8");

	}

	@Override
	public void doHFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		request.setCharacterEncoding("UTF8");

		response.setContentType("text/html; charset=UTF-8");

		chain.doFilter(request, response);

	}

}
