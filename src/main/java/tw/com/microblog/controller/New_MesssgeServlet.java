package tw.com.microblog.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.microblog.bean.Messagez;
import tw.com.microblog.dao.MemberDao;
import tw.com.microblog.dao.MessagesDao;
import tw.com.microblog.factory.Factory;


@WebServlet("/new_MesssgeServlet")
public class New_MesssgeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public New_MesssgeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String message = request.getParameter("message");
		MemberDao mdao = Factory.getMemberFactory();
		String username = mdao.getUserName(request);

		MessagesDao mbmdao = Factory.getMessagesFactory();
		Messagez mbmessage = new Messagez();
		mbmessage.setMessage(message);
		mbmessage.setUsername(username);

		List<Messagez> mmlist = mbmdao.getAllMessage(username);
		request.setAttribute("MemberMessages", mmlist);

		if (message.length() >= 100) {
			request.setAttribute("errormessage", "請勿超過100個字");
			request.getRequestDispatcher("search_MessageServlet").forward(request, response);
		} else {
			mbmdao.addMessage(mbmessage);
			request.getRequestDispatcher("search_MessageServlet").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
