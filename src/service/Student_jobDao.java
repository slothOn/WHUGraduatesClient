package service;

import java.util.List;

import entity.Student_job;
import entity.Student_school;

public interface Student_jobDao {
	public List<Student_job> getjoblistBySid(String sid);
	public boolean deleteAndUpdate(String sid, List<Student_job> list);
}
