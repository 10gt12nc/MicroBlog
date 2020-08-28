package tw.com.microblog.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.microblog.dao.MemberDao;
import tw.com.microblog.factory.Factory;


@WebServlet("/mailVerifyServlet")
public class MailVerifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MailVerifyServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		int id=Integer.parseInt(request.getParameter("id"));
		String email=request.getParameter("email");
		int salt=Integer.parseInt(request.getParameter("salt"));
		
		MemberDao md=Factory.getMemberFactory();
		md.activateEmail(id,email,salt);
		
		response.sendRedirect("/WEB-INF/views/mailverify_OK.jsp");
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
