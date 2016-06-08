package service;

public interface UserDao {
	public boolean checkUser(String username, String password);
	public boolean insertUser(String sid, String sname, String password);
}
