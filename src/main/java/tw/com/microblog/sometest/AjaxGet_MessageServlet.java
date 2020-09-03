package tw.com.microblog.sometest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import tw.com.microblog.bean.Messagez;
import tw.com.microblog.dao.MessagesDao;
import tw.com.microblog.factory.Factory;

@WebServlet("/AjaxGet_MessageServlet")
public class AjaxGet_MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AjaxGet_MessageServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MessagesDao msdao = Factory.getMessagesFactory();
		List<Messagez> mlist = msdao.getAllMessage();
		
		JSONArray json01 = JSONArray.fromObject(mlist);
		PrintWriter out = response.getWriter();
		out.print(json01);
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		// 得到ajax傳遞過來的paramater
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		System.out.print(name+":"+pass);

		AJ_TestUser u1 = new AJ_TestUser();
		u1.setUsername(name);
		u1.setPassword(pass);

		AJ_TestUser u2 = new AJ_TestUser();
		u2.setUsername("LI");
		u2.setPassword("456");

		List list = new ArrayList();// 傳遞List
		list.add(u1); // 新增User物件
		list.add(u2); // 新增User物件
		//[ {"password":"","username":""},
		//  {"password":"456","username":"LI"} ]
		
		
	//	Map m = new HashMap();// 傳遞Map
	//	m.put("u1", u1);
	//	m.put("u2", u2);
		//{ "u1":{"password":"","username":""},
		//  "u2":{"password":"456","username":"LI"} }
		
		
		
		// 把list轉成json字串
		JSONArray json01 = JSONArray.fromObject(list);
		
		// 轉Map為Json字串
	//	JSONObject json02=JSONObject.fromObject(m);

		PrintWriter out = response.getWriter();
		out.print(json01);// 返給ajax請求
	//	out.print(json02);// 返給ajax請求
		
		
		
	}

}
