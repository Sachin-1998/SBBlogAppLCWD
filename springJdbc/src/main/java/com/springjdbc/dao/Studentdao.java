package com.springjdbc.dao;

import java.util.List;

import com.springJdbc.entities.Student;

public interface Studentdao 
{
	public int insert(Student student);
	public int change(Student student);
	public int delete(int studentid);
	public Student getStudent(int studentid);
	public List<Student> getAllStudents();
}
