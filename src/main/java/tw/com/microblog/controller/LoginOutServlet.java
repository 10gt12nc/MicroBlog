package tw.com.microblog.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginOutServlet")
public class LoginOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginOutServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(request.getSession().getAttribute("login") !=null) {
			request.getSession().invalidate();
		}
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);

		//		response.sendRedirect("/WEB-INF/views/login.jsp");
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
