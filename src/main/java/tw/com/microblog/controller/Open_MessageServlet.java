package tw.com.microblog.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.microblog.bean.Messagez;
import tw.com.microblog.dao.MessagesDao;
import tw.com.microblog.factory.Factory;


@WebServlet("/open_MessageServlet")
public class Open_MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Open_MessageServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String open = request.getParameter("open");

		MessagesDao mgdao = Factory.getMessagesFactory();
		Messagez message = new Messagez();

		if (open.equals("true")) {
			message.setOpenmessage(true);
			Boolean bl = message.getOpenmessage();
			mgdao.openMessage(id, bl);
		} else {
			message.setOpenmessage(false);
			Boolean bl = message.getOpenmessage();
			mgdao.openMessage(id, bl);
		}

		request.getRequestDispatcher("search_MessageServlet").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
