package tw.com.microblog.dao;

import java.util.List;

import tw.com.microblog.bean.Messagez;


public interface MessagesDao {
	
	// 新增訊息
	public void addMessage(Messagez message);

	// 查所有訊息ByName
	public List<Messagez> getAllMessage(String username);
	
	// 所有公開訊息
	public List<Messagez> getAllMessage();

	// 刪
	public void deleteUser(int id);

	// 編輯訊息
	public void updateMessagez(int id, String message);
	
	
	//公開訊息
	public void openMessage(int id, Boolean bl);

}
