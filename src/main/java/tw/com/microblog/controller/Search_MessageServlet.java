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


@WebServlet("/search_MessageServlet")
public class Search_MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Search_MessageServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MemberDao mdao = Factory.getMemberFactory();
		String username = mdao.getUserName(request);
		MessagesDao msdao = Factory.getMessagesFactory();
		List<Messagez> mlist = msdao.getAllMessage(username);
		request.setAttribute("Messagez", mlist);
		request.getRequestDispatcher("/WEB-INF/views/member.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
