package tw.com.microblog.unittest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;

import tw.com.microblog.bean.Memberz;
import tw.com.microblog.bean.Messagez;
import tw.com.microblog.dao.MemberDao;
import tw.com.microblog.dao.MessagesDao;
import tw.com.microblog.factory.Factory;
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
	

	@Test //亂數鹽值
	public void salt() {
		Random r = new Random();
		String[] sixNum = new String[3];
		String ssum="";
		for (int i = 0; i < 3; i++) {
			sixNum[i] = String.valueOf(r.nextInt(49) + 1);
			ssum += sixNum[i] ;
		}
		System.out.println(ssum);
		
//		for(String s:sixNum) {
//		System.out.println(s);	
//		}
		
//		String arrayString = String.join(",", sixNum);
//		System.out.println(arrayString);
	}

	@Test // 有無mail
	public void checkEmail() {

		MemberDao MD = Factory.getMemberFactory();
		Boolean bl = MD.checkEmail("1001245nc@gmail.com");
		System.out.println(bl);

	}

	@Test // 驗證
	public void activate() {
//		Memberz mb = new Memberz();
//		mb.setUsername("Ax鄰u2林");
//		String name = "Ax鄰u2林";
		MemberDao MD = Factory.getMemberFactory();
//		MD.activateEmail(mb);
//		MD.activateEmail(name);
	}


	// 刪訊息
	@Test
	public void delTest() {
		int id = 4;
		MessagesDao mdao = Factory.getMessagesFactory();
		mdao.deleteUser(id);
	}

	// 名稱撈訊息
	@Test
	public void searchTest() {
		String username = "Nick林";
		MessagesDao mdao = Factory.getMessagesFactory();
		List<Messagez> mlist = mdao.getAllMessage(username);
		Iterator<Messagez> im = mlist.iterator();
		while (im.hasNext()) {
			System.out.println(im.next());
		}
	}

	// 登入
	@Test
	public void loginTest() {
//		String username = "Ax鄰u2林";
//		String passwd1 = "789456";
		String username = "0xu李";
		String passwd1 = "789456";
		MemberDao mbdao = Factory.getMemberFactory();
		boolean bllogin = mbdao.getLogin(username, passwd1);
		System.out.println(bllogin);

	}

	// 新增
	@Test
	public void creatUserTest() {

		String username = "li";
		String passwd1 = "1666";
		String passwd2 = "1666";
		String email = "998@h2525";

		Memberz mbz = new Memberz();
		mbz.setUsername(username);
		mbz.setPassword1(passwd1);
		mbz.setPassword2(passwd2);
		mbz.setEmail(email);

		MemberDao mbdao = Factory.getMemberFactory();
		mbdao.addUser(mbz);
	}

	// 驗證有無使用者
	@Test
	public void hasUserTest() {
		System.out.println(hasUser("ttest0001"));
		System.out.println(hasUser("測試001"));
		System.out.println(hasUser("測試00155336"));
		System.out.println(hasUser("0"));
	}

	public boolean hasUser(String username) {
		boolean bluser = false;
		try {
			FileReader fr = new FileReader("C:\\Users\\1070322\\Desktop\\user\\users.txt");
			BufferedReader bfr = new BufferedReader(fr);
			String user = bfr.readLine();
			System.out.println(user);
			System.out.println("讀檔完成");
			if (user.equals(username)) {
				bluser = true;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return bluser;
	}

	// 寫入
	@Test
	public void writeTest() {
		try {

			String path, newdata;
			path = "C:\\Users\\1070322\\Desktop\\user\\users.txt";

			newdata = "測試001";
			BufferedWriter out = new BufferedWriter(new FileWriter(path, true));
			out.write(newdata);
			out.newLine();
			out.close();

			System.out.println(path + "--" + "寫檔完成,加了:" + newdata);
		} catch (IOException e) {
			System.out.println("路徑有誤!");
		}
	}

	// 讀檔
	@Test
	public void readTest() {

		try {
			FileReader fr = new FileReader("C:\\Users\\1070322\\Desktop\\user\\users.txt");
			BufferedReader bfr = new BufferedReader(fr);
			String user = bfr.readLine();
			System.out.println(user);
			System.out.println("讀檔完成");

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	

}
