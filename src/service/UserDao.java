package service;

import java.util.List;

public interface UserDao {
	public List checkUser(String username, String password);
	public boolean insertUser(String sid, String sname, String password);
}
