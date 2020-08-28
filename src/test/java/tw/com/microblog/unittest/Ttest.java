package tw.com.microblog.unittest;

import org.junit.jupiter.api.Test;

import tw.com.microblog.sometest.GMailTest;

public class Ttest {

	// JavaMail測試
	@Test
	public void mailTest() {

		String To_mail = "linmicroblog@gmail.com";
		String Mail_title = "安安";
		String Mail_text = "這是測試郵件";
		GMailTest.Send_mail(To_mail, Mail_title, Mail_text);

	}

}
