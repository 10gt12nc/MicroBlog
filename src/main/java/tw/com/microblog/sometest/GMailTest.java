package tw.com.microblog.sometest;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class GMailTest {
	

	static String host = "smtp.gmail.com";
	static int port = 587;
	static final String username = "linmicroblog@gmail.com";

	static final String password = "l123d456k789";


	public static void Send_mail(String To_mail, String Mail_title, String Mail_text) {
        
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", port);
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(To_mail));
            message.setSubject(Mail_title);
            message.setText(Mail_text);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, port, username, password);
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
	}
}
