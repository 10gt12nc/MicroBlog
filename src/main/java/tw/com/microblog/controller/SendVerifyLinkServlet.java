package tw.com.microblog.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.microblog.dao.MemberDao;
import tw.com.microblog.factory.Factory;


@WebServlet("/sendVerifyLinkServlet")
public class SendVerifyLinkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SendVerifyLinkServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		int id = Integer.parseInt(request.getParameter("id"));
		String email = request.getParameter("email");
		
		MemberDao md = Factory.getMemberFactory();
		int salt = md.getSaltBy(id, email);

		String link="http://localhost:8080/MicroBlog/mailVerifyServlet?id="+id+"&email="+email;
		String text = link + "&salt=" + salt;
	
		request.setAttribute("subject", "開通郵件");
		request.setAttribute("text", text);
		request.getRequestDispatcher("mailServlet").forward(request, response);
	
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
