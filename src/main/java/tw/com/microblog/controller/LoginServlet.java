package tw.com.microblog.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.microblog.dao.MemberDao;
import tw.com.microblog.factory.Factory;


@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String passwd = request.getParameter("passwd");

		MemberDao mbdao = Factory.getMemberFactory();
		boolean bllong = mbdao.getLogin(username, passwd);

		if (bllong) {
			// 如果沒Session就是null
			if (request.getSession(false) != null) {
				request.changeSessionId();
			}
			request.getSession().setAttribute("login", username);
			request.getRequestDispatcher("/WEB-INF/views/login_success.jsp").forward(request, response);
		} else {
			response.sendRedirect("/WEB-INF/views/login.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
