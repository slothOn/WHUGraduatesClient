package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stuuser")
public class User {
	
	public User(){}
	
	public User(String sid, String sname, String password) {
		this.sid = sid;
		this.sname = sname;
		this.password = password;
	}
	
	@Id
	@Column(name="sid")
	private String sid;
	@Column(name="sname")
	private String sname;
	@Column(name="password")
	private String password;
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
}
