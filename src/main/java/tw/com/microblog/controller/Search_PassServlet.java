package tw.com.microblog.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.microblog.dao.MemberDao;
import tw.com.microblog.factory.Factory;


@WebServlet("/search_PassServlet")
public class Search_PassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Search_PassServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String email = request.getParameter("email");
		
		MemberDao md=Factory.getMemberFactory();
		
		Boolean bln=md.checkName(username);
		Boolean ble=md.checkEmail(email);
		if(!bln || !ble) {
			request.setAttribute("error", "無此帳號或郵件");
			request.getRequestDispatcher("/WEB-INF/views/forgetpass.jsp").forward(request, response);
		}else {
			String pass=md.getUserPass(username, email);
			int id=md.getIdBy(username, email);
			request.setAttribute("id", id);
			request.setAttribute("pass", pass);
			request.getRequestDispatcher("/WEB-INF/views/forgetpass.jsp").forward(request, response);
		}
		
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
