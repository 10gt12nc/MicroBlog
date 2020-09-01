package tw.com.microblog.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.microblog.dao.MemberDao;
import tw.com.microblog.factory.Factory;


@WebServlet("/reset_PassServlet")
public class Reset_PassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Reset_PassServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String pass=(String) request.getParameter("pass");
		
		String pass1 = request.getParameter("pass1");
		String pass2 = request.getParameter("pass2");

		MemberDao md = Factory.getMemberFactory();
		
		// 字數最小限制未處理

		if (pass1.equals(pass2)) {
			md.updatePass(id, pass1, pass2);
		} else {
			request.setAttribute("id",id);
			request.setAttribute("pass",pass);
			request.setAttribute("error2","密碼須相同");
			request.getRequestDispatcher("/WEB-INF/views/forgetpass.jsp").forward(request, response);
		}
		
		request.getSession().invalidate();
		request.getRequestDispatcher("/WEB-INF/views/resetpass_OK.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
