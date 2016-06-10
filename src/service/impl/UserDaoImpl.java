package service.impl;

import java.util.List;

import entity.User;
import service.UserDao;
import util.MD5Util;

public class UserDaoImpl extends BaseDaoHibernate4<User> implements UserDao{
	public List checkUser(String username, String password){
		String hql = "from User where sid=? and password=?";
		List list = find(hql, username, MD5Util.MD5Encode(password));
		return list;
	}

	@Override
	public boolean insertUser(String sid, String sname, String password) {
		// TODO Auto-generated method stub
		User user = new User(sid, sname, MD5Util.MD5Encode(password));
		String rs = (String)save(user);
		if(rs != null && !"".equals(rs)){
			return true;
		}
		return false;
	}
	
}
