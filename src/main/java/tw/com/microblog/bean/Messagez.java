package tw.com.microblog.bean;

import java.io.Serializable;

public class Messagez implements Serializable {

	private Integer id;
	private String username;
	private String message;
	// MySQL:T=1;F=0;
	private Boolean openmessage = false; 


	public Messagez() {
		super();
	}

	public Messagez(Integer id, String username, String message) {
		super();
		this.id = id;
		this.username = username;
		this.message = message;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getOpenmessage() {
		return openmessage;
	}

	public void setOpenmessage(Boolean openmessage) {
		this.openmessage = openmessage;
	}

	@Override
	public String toString() {
		return "Messagez [id=" + id + ", username=" + username + ", message=" + message + "]";
	}

}
