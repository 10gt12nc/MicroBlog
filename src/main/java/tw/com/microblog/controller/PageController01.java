package tw.com.microblog.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import tw.com.microblog.baseservlet.BaseServlet;
import tw.com.microblog.bean.Memberz;
import tw.com.microblog.bean.Messagez;
import tw.com.microblog.dao.MemberDao;
import tw.com.microblog.dao.MessagesDao;
import tw.com.microblog.factory.Factory;

@WebServlet(name = "pc01", urlPatterns = "*.do")
public class PageController01 extends BaseServlet {

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

	// /login.do
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String passwd = request.getParameter("passwd");

		MemberDao mbdao = Factory.getMemberFactory();
		boolean bllogin = mbdao.getLogin(username, passwd);

		if (bllogin) {
			if (request.getSession(false) != null) {
				request.changeSessionId();
			}
			request.getSession().setAttribute("login", username);
			request.getRequestDispatcher("/WEB-INF/views/login_success.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}

	}

	// /loginOut.do
	public void loginOut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("login") != null) {
			request.getSession().invalidate();
		}
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);

	}

	// /mailVerify.do
	public void mailVerify(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String email = request.getParameter("email");
		int salt = Integer.parseInt(request.getParameter("salt"));

		MemberDao md = Factory.getMemberFactory();
		md.activateEmail(id, email, salt);
		request.getRequestDispatcher("/WEB-INF/views/mailverify_OK.jsp").forward(request, response);

	}

	// /reset_Password.do
	public void reset_Password(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String pass = (String) request.getParameter("pass");

		String pass1 = request.getParameter("pass1");
		String pass2 = request.getParameter("pass2");

		MemberDao md = Factory.getMemberFactory();

		// 字數最小限制和兩次密碼驗證未處理

		if (pass1.equals(pass2)) {
			md.updatePass(id, pass1, pass2);
		} else {
			request.setAttribute("id", id);
			request.setAttribute("pass", pass);
			request.setAttribute("error2", "密碼須相同");
			request.getRequestDispatcher("/WEB-INF/views/forgetpass.jsp").forward(request, response);
		}

		request.getSession().invalidate();
		request.getRequestDispatcher("/WEB-INF/views/resetpass_OK.jsp").forward(request, response);

	}

	// /sendVerifyLink.do
	public void sendVerifyLink(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String email = request.getParameter("email");

		MemberDao md = Factory.getMemberFactory();
		int salt = md.getSaltBy(id, email);

		String link = "http://localhost:8080/MicroBlog/mailVerify.do?id=" + id + "&email=" + email;
		String text = link + "&salt=" + salt;

		request.setAttribute("subject", "開通郵件");
		request.setAttribute("text", text);
		request.getRequestDispatcher("mailServlet").forward(request, response);

	}

	// /search_Password.do
	public void search_Password(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String email = request.getParameter("email");

		MemberDao md = Factory.getMemberFactory();

		Boolean bln = md.checkName(username);
		Boolean ble = md.checkEmail(email);
		if (!bln || !ble) {
			request.setAttribute("error", "無此帳號或郵件");
			request.getRequestDispatcher("/WEB-INF/views/forgetpass.jsp").forward(request, response);
		} else {
			String pass = md.getUserPass(username, email);
			int id = md.getIdBy(username, email);
			request.setAttribute("id", id);
			request.setAttribute("pass", pass);
			request.getRequestDispatcher("/WEB-INF/views/forgetpass.jsp").forward(request, response);
		}

	}

	// /mail_GetPassword.do
	public void mail_GetPassword(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("username");
		String email = request.getParameter("email");

		MemberDao md = Factory.getMemberFactory();
		int id = md.getIdBy(name, email);
		String pass = md.getUserPass(name, email);

		if (id > 0) {
			request.setAttribute("subject", "妳的密碼");
			request.setAttribute("text", pass);
			request.getRequestDispatcher("mailServlet").forward(request, response);

		} else {
			request.setAttribute("message", "無此帳號或郵件");
			request.getRequestDispatcher("/WEB-INF/views/retrieve_pass.jsp").forward(request, response);

		}

	}

	// /new_Messsge.do
	public void new_Messsge(HttpServletRequest request, HttpServletResponse response)
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
			request.getRequestDispatcher("search_Message.do").forward(request, response);
		} else {
			mbmdao.addMessage(mbmessage);
			request.getRequestDispatcher("search_Message.do").forward(request, response);
		}

	}

	// /delete_Message.do
	public void delete_Message(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		MessagesDao mdao = Factory.getMessagesFactory();
		mdao.deleteUser(id);
		response.sendRedirect("search_Message.do");

	}

	// /edit_Message.do
	public void edit_Message(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String message = request.getParameter("new_message");
		MessagesDao mgdao = Factory.getMessagesFactory();

		if (message.length() >= 100) {
			request.setAttribute("errormessage", "請勿超過100個字");
			request.getRequestDispatcher("/WEB-INF/views/edit_message.jsp").forward(request, response);
		} else {
			mgdao.updateMessagez(id, message);
			response.sendRedirect("search_Message.do");

		}

	}

	// /search_Message.do
	public void search_Message(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MemberDao mdao = Factory.getMemberFactory();
		String username = mdao.getUserName(request);
		MessagesDao msdao = Factory.getMessagesFactory();
		List<Messagez> mlist = msdao.getAllMessage(username);
		request.setAttribute("Messagez", mlist);
		request.getRequestDispatcher("/WEB-INF/views/member.jsp").forward(request, response);

	}

	// /open_Message.do
	public void open_Message(HttpServletRequest request, HttpServletResponse response)
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

		request.getRequestDispatcher("search_Message.do").forward(request, response);

	}

	// /get_OpenMessage.do
	public void get_OpenMessage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MessagesDao msdao = Factory.getMessagesFactory();
		List<Messagez> mlist = msdao.getAllMessage();

		
		JSONArray json01 = JSONArray.fromObject(mlist);

		PrintWriter out = response.getWriter();
		out.print(json01);

	}

	// /.do
	public void add15(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
