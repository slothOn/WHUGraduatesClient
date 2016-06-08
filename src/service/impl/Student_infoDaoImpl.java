package service.impl;

import java.util.List;

import entity.Student_info;
import service.Student_infoDao;

public class Student_infoDaoImpl extends BaseDaoHibernate4<Student_info> implements Student_infoDao{

	@Override
	public Student_info getStudentinfoBysid(String sid) {
		// TODO Auto-generated method stub
		return findById(sid, Student_info.class);
	}

	@Override
	public boolean saveorupdateStudentinfo(Student_info stu) {
		// TODO Auto-generated method stub
		update(stu);
		return true;
	}
	
}
