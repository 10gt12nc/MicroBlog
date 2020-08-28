package tw.com.microblog.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import tw.com.microblog.bean.Memberz;

public interface MemberDao {

	// 增
	public void addUser(Memberz mb);

	// 刪
	public void deleteUser(int id);

	//改密碼
	public void updatePass(int id ,String newpass, String newpass2);

	// 查
	public List<Memberz> getAll();

	// 查有無相同帳號
	public boolean checkName(String username);

	// 用帳號查
	public List<Memberz> getUserByName(String username);

	// 用郵件帳號
	public List<Memberz> getUserByEmail(String email);
	
	// 用郵件查ID
	public int getIdByEmail(String email);
	public int getIdBy(String name, String email);
	
	// 查salt
	public int getSaltBy(int id,String email);
	
	
	public String getUserPass(String username, String email);

	public boolean getLogin(String username, String password);

	public int getPassLogin(String username, String email, int a);

	// 將login屬性轉為UserName名稱
	public String getUserName(HttpServletRequest request);

	// 查有無相同Email
	// Optional<Memberz> checkEmail(String username);
	public boolean checkEmail(String username);

	// mail激活
	void activateEmail(int id,String email, int salt);
}
