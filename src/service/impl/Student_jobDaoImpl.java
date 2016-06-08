package service.impl;

import java.util.List;

import entity.Student_job;
import entity.Student_school;
import service.Student_jobDao;

public class Student_jobDaoImpl extends BaseDaoHibernate4<Student_job> implements Student_jobDao{

	@Override
	public List<Student_job> getjoblistBySid(String sid) {
		// TODO Auto-generated method stub
		return find("from Student_job where sid=?", sid);
	}

	@Override
	public boolean deleteAndUpdate(String sid, List<Student_job> list) {
		// TODO Auto-generated method stub
		deleteByOneCol(Student_job.class, "sid", sid);
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
