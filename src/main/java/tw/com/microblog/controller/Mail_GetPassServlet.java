package tw.com.microblog.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.microblog.dao.MemberDao;
import tw.com.microblog.factory.Factory;


@WebServlet("/mail_GetPassServlet")
public class Mail_GetPassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Mail_GetPassServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("username");
		String email = request.getParameter("email");

		MemberDao md = Factory.getMemberFactory();
		int id = md.getIdBy(name, email);
		String pass = md.getUserPass(name, email);

		if (id > 0) {
			request.setAttribute("subject", "妳的密碼");
			request.setAttribute("text", pass);
			request.getRequestDispatcher("mail").forward(request, response);

		} else {
			request.setAttribute("message", "無此帳號或郵件");
			request.getRequestDispatcher("/WEB-INF/views/retrieve_pass.jsp").forward(request, response);

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
