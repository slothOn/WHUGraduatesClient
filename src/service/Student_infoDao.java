package service;

import entity.Student_info;

public interface Student_infoDao {
	public Student_info getStudentinfoBysid(String sid);
	public boolean saveorupdateStudentinfo(Student_info stu);
}
