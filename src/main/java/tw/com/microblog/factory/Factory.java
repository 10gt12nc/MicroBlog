package tw.com.microblog.factory;

import tw.com.microblog.dao.MemberDao;
import tw.com.microblog.dao.MessagesDao;
import tw.com.microblog.daoimpl.MemberDaoImpl;
import tw.com.microblog.daoimpl.MessagesDaoImpl;

public class Factory {

	public static MemberDao getMemberFactory() {
		return new MemberDaoImpl();
	}
	
	public static MessagesDao getMessagesFactory() {
		return new MessagesDaoImpl();
	}
	
	
}
