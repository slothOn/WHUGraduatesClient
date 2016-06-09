package service.impl;

import java.util.List;

import entity.User;
import service.UserDao;

public class UserDaoImpl extends BaseDaoHibernate4<User> implements UserDao{
	public boolean checkUser(String username, String password){
		String hql = "from User where sid=? and password=?";
		List list = find(hql, username, password);
		if(list != null && list.size() > 0) return true;
		return false;
	}

	@Override
	public boolean insertUser(String sid, String sname, String password) {
		// TODO Auto-generated method stub
		User user = new User(sid, sname, password);
		String rs = (String)save(user);
		if(rs != null && !"".equals(rs)){
			return true;
		}
		return false;
	}
	
}