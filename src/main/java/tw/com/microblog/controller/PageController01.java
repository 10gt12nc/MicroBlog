package tw.com.microblog.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.microblog.bean.Memberz;
import tw.com.microblog.dao.MemberDao;
import tw.com.microblog.factory.Factory;

@WebServlet(name = "pc01", urlPatterns = "*.do")
public class PageController01 extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.service(request, response);
	}

	// 鹽值
	private String salt() {
		Random r = new Random();
		String[] sixNum = new String[3];
		String ssum = "";
		for (int i = 0; i < 3; i++) {
			sixNum[i] = String.valueOf(r.nextInt(49) + 1);
			ssum += sixNum[i];
		}

		return ssum;
	}
	// /register.do
	public void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String passwd1 = request.getParameter("passwd1");
		String passwd2 = request.getParameter("passwd2");
		String email = request.getParameter("email");

		Memberz mbz = new Memberz();
		mbz.setUsername(username);
		mbz.setPassword1(passwd1);
		mbz.setPassword2(passwd2);
		mbz.setEmail(email);

		String salt = salt();
		int isalt = Integer.parseInt(salt);
		mbz.setSalt(isalt);

		MemberDao mbdao = Factory.getMemberFactory();
		mbdao.addUser(mbz);

		int id = mbdao.getIdByEmail(email);

		request.setAttribute("id", id);
		request.setAttribute("email", email);

		request.getRequestDispatcher("/WEB-INF/views/register_success.jsp").forward(request, response);

	}

	public void add2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OKKK");
		request.getRequestDispatcher("TestBaseServlet.jsp").forward(request, response);
	}

	public void add3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OKKK");
		request.getRequestDispatcher("TestBaseServlet.jsp").forward(request, response);
	}

	public void add4(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OKKK");
		request.getRequestDispatcher("TestBaseServlet.jsp").forward(request, response);
	}

	public void add5(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OKKK");
		request.getRequestDispatcher("TestBaseServlet.jsp").forward(request, response);
	}

	public void add6(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OKKK");
		request.getRequestDispatcher("TestBaseServlet.jsp").forward(request, response);
	}

	public void add7(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OKKK");
		request.getRequestDispatcher("TestBaseServlet.jsp").forward(request, response);
	}

	public void add8(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OKKK");
		request.getRequestDispatcher("TestBaseServlet.jsp").forward(request, response);
	}

	public void add9(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OKKK");
		request.getRequestDispatcher("TestBaseServlet.jsp").forward(request, response);
	}

	public void add10(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OKKK");
		request.getRequestDispatcher("TestBaseServlet.jsp").forward(request, response);
	}

	public void add11(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OKKK");
		request.getRequestDispatcher("TestBaseServlet.jsp").forward(request, response);
	}

	public void add12(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OKKK");
		request.getRequestDispatcher("TestBaseServlet.jsp").forward(request, response);
	}

	public void add13(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OKKK");
		request.getRequestDispatcher("TestBaseServlet.jsp").forward(request, response);
	}

	public void add14(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OKKK");
		request.getRequestDispatcher("TestBaseServlet.jsp").forward(request, response);
	}

	public void add15(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OKKK");
		request.getRequestDispatcher("TestBaseServlet.jsp").forward(request, response);
	}

}
