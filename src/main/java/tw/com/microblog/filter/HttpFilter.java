package tw.com.microblog.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//自己寫試試看
public abstract class HttpFilter implements Filter {

	 private FilterConfig filterConfig;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

		this.filterConfig=filterConfig;
	
	}
	
	public void init() throws ServletException{}
	
	public FilterConfig getFilterConfig() {
		return filterConfig;
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		doHttpFilter(request, response, chain);
		
		
	}
	
	public abstract void doHttpFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException ;

	
	@Override
	public void destroy() {
	}
	
	
}
