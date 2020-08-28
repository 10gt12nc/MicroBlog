package tw.com.microblog.bean;

import java.io.Serializable;

public class Memberz implements Serializable {

	private Integer id;
	private String username;
	private String password1;
	private String password2;
	private String email;
	// MySQL:T=1;F=0; 預設0未啟用
	private Boolean role = false; 
	private int salt;

	public Memberz() {
		super();
	}

	public Memberz(Integer id, String username, String password1, String password2, String email, Boolean role,
			int salt) {
		super();
		this.id = id;
		this.username = username;
		this.password1 = password1;
		this.password2 = password2;
		this.email = email;
		this.role = role;
		this.salt = salt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getRole() {
		return role;
	}

	public void setRole(Boolean role) {
		this.role = role;
	}

	public int getSalt() {
		return salt;
	}

	public void setSalt(int salt) {
		this.salt = salt;
	}

	@Override
	public String toString() {
		return "Memberz [id=" + id + ", username=" + username + ", password1=" + password1 + ", password2=" + password2
				+ ", email=" + email + ", role=" + role + ", salt=" + salt + "]";
	}

}
