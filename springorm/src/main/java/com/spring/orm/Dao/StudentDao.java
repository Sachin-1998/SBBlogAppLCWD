package com.spring.orm.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

public class StudentDao
{
	private HibernateTemplate template;
	@Transactional
	public int insert(Student student)
	{
		Integer r=(Integer) this.template.save(student);
		return r;
		
	}
	//to get single student
	public Student getStudent(int studentId)
	{
		Student s=this.template.get(Student.class,studentId);
		return s;
	}
	//to get all student
	public List<Student> getAllStudent()
	{
		List<Student> s1=this.template.loadAll(Student.class);
		return s1;
	}
	
	//to delete student
	@Transactional
	public int removeStudent(int studentId)
	{
		Student s3=this.template.get(Student.class,studentId);
		this.template.delete(s3);
		return studentId;
	}
	//update student
	@Transactional
	public Student updateStudent(Student student)
	{
		this.template.update(student);
		return student;
	}
	public HibernateTemplate getTemplate() {
		return template;
	}
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	

}
