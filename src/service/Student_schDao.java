package service;

import java.util.List;

import entity.Student_school;

public interface Student_schDao {
	public List<Student_school> getschoollistBySid(String sid);
	public boolean deleteAndUpdate(String sid, List<Student_school> list);
}
