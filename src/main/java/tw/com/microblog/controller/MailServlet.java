package tw.com.microblog.controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = { "/mailServlet" }, initParams = { @WebInitParam(name = "host", value = "smtp.gmail.com"),
		@WebInitParam(name = "port", value = "587"), @WebInitParam(name = "user", value = "linmicroblog@gmail.com"),
		@WebInitParam(name = "pass", value = "lin123dd456") })
public class MailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String host;
	private int port;
	private String user;
	private String pass;
	private Properties props;

	public MailServlet() {
		super();
	}

	@Override
	public void init() throws ServletException {
		host = getServletConfig().getInitParameter("host");
		port = Integer.parseInt(getServletConfig().getInitParameter("port"));
		user = getServletConfig().getInitParameter("user");
		pass = getServletConfig().getInitParameter("pass");

		props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.port", port);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		String form = request.getParameter("form");
		String form = "linmicroblog@gmail.com";
		
//		String to = request.getParameter("to");
		String to = "linmicroblog@gmail.com";
		
//		String subject = request.getParameter("subject");
		String subject = (String) request.getAttribute("subject");

//		String text = request.getParameter("text");
		String text = (String) request.getAttribute("text");

		try {
			Message message = creatMessage(form, to, subject, text);
			Transport.send(message);
//			System.out.println("郵件傳送成功");
			response.getWriter().print("郵件傳送成功,請到信箱確認");
			

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

	private Message creatMessage(String form, String to, String subject, String text) throws MessagingException {
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, pass);
			}
		});

		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(user));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
		message.setSubject(subject);
		message.setText(text);
		Transport transport = session.getTransport("smtp");
		transport.connect(host, port, user, pass);
		return message;

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
