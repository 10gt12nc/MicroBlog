package tw.com.microblog.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.microblog.bean.Messagez;
import tw.com.microblog.dao.MessagesDao;
import tw.com.microblog.factory.Factory;


@WebServlet("/get_OpenMessageServlet")
public class Get_OpenMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Get_OpenMessageServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MessagesDao msdao = Factory.getMessagesFactory();
		List<Messagez> mlist = msdao.getAllMessage();
		request.setAttribute("OMessagez", mlist);
		
		
		request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
	
	
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
