package tw.com.microblog.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.microblog.dao.MessagesDao;
import tw.com.microblog.factory.Factory;


@WebServlet("/edit_MessageServlet")
public class Edit_MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Edit_MessageServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String message = request.getParameter("new_message");
		MessagesDao mgdao = Factory.getMessagesFactory();

		if (message.length() >= 100) {
			request.setAttribute("errormessage", "請勿超過100個字");
			request.getRequestDispatcher("/WEB-INF/views/edit_message.jsp").forward(request, response);
		} else {
			mgdao.updateMessagez(id, message);
			response.sendRedirect("search_Message");

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
