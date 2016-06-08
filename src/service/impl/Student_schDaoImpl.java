package service.impl;

import java.util.List;

import entity.Student_school;
import service.Student_schDao;

public class Student_schDaoImpl extends BaseDaoHibernate4<Student_school> implements Student_schDao{

	@Override
	public List<Student_school> getschoollistBySid(String sid) {
		// TODO Auto-generated method stub
		return find("from Student_school where sid=?", sid);
	}

	@Override
	public boolean deleteAndUpdate(String sid, List<Student_school> list) {
		// TODO Auto-generated method stub
		deleteByOneCol(Student_school.class, "sid", sid);
		for(int i = 0; i < list.size(); i++){
			getSessionFactory().getCurrentSession().save(list.get(i));
			if(i % 20 == 0){
				getSessionFactory().getCurrentSession().flush();
				getSessionFactory().getCurrentSession().clear();
			}
		}
		return true;
	}

}
