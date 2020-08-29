package tw.com.microblog.filter;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import tw.com.microblog.dao.MemberDao;
import tw.com.microblog.factory.Factory;


//驗證格式
class ValidateFormat {
	private final Pattern usernameRegex = Pattern.compile("^[\\w\\u4e00-\\u9fa5]{1,16}$");
	/*
	 * \w 等於 [a-zA-Z_0-9] 數字或是英文字 {n,m}至少 n ，至多 m $ 結束
	 */
	private final Pattern passwdRegex = Pattern.compile("^\\w{6,16}$");
	private final Pattern emailRegex = Pattern
			.compile("^\\w{1,63}@[a-zA-Z0-9]{2,63}\\.[a-zA-Z]{2,63}(\\.[a-zA-Z]{2,63})?$");

	boolean validateUsername(String username) {
		return usernameRegex.matcher(username).find();
	}

	boolean validatePassword(String password, String password2) {
		return passwdRegex.matcher(password).find() && password.equals(password2);
	}

	boolean validateEmail(String email) {
		return emailRegex.matcher(email).find();
	}

}

@WebFilter("/registerServlet")
public class ValidateRegister implements Filter {

	public ValidateRegister() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String username = request.getParameter("username");
		String password = request.getParameter("passwd1");
		String password2 = request.getParameter("passwd2");
		String email = request.getParameter("email");

		MemberDao mbdao = Factory.getMemberFactory();
		boolean blhasuser = mbdao.checkName(username);
		boolean blhasemail=mbdao.checkEmail(email);
		
		ValidateFormat valfm = new ValidateFormat();
		boolean blname = valfm.validateUsername(username);
		boolean blpass = valfm.validatePassword(password, password2);
		boolean blemail = valfm.validateEmail(email);

		if (blhasuser || blhasemail) {
			request.setAttribute("message2", "帳號或郵件已存在");
			request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);

		} else {
			if (!blname || !blpass || !blemail) {
				request.setAttribute("message", "未填寫或格式錯誤");
				request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
			} else {
				chain.doFilter(request, response);
			}
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
