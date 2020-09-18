package tw.com.microblog.baseservlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getServletPath();
		String mypath = path.substring(1, path.length() - 3);
		System.out.println(path);
		System.out.println(mypath);
		try {
			Method method = getClass().getDeclaredMethod(mypath, HttpServletRequest.class, HttpServletResponse.class);
			method.invoke(this, request, response);
			// invoke�ե� this�N�Oadd ��query �Ψ�L

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
