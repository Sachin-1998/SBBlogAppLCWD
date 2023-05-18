package com.springjdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.springJdbc.entities.Student;

@Component("studentdao")
public class StudentDaoImpl implements Studentdao {

	@Autowired
	private JdbcTemplate jdbctemplate;

	public int insert(Student student) {
		String Query = "insert into Student() values(?,?,?,?)";
		int record = this.jdbctemplate.update(Query, student.getId(), student.getName(), student.getMarks(),
				student.getCity());
		return record;
	}

	public int change(Student student) {
		String query = "update Student set name=?, marks=?, city=? where id=?";
		int record = this.jdbctemplate.update(query, student.getName(), student.getMarks(), student.getCity(),
				student.getId());
		return record;
	}

//	public int delete(Student student) {
//		String query="delete from Student where id=?";
//		int record=this.jdbctemplate.update(query,student.getId());
//		return record;
//	}
	public int delete(int studentid) {
		String query = "delete from Student where id=?";
		int record = this.jdbctemplate.update(query, studentid);
		return record;
	}

	public Student getStudent(int studentid) {
		// select single student
		String query = "select * from Student where id=?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student = this.jdbctemplate.queryForObject(query, rowMapper, studentid);
		return student;
	}

	public List<Student> getAllStudents() {
		String query = "select * from Student";
		List<Student> student = this.jdbctemplate.query(query, new RowMapperImpl());
		return student;
	}

	public JdbcTemplate getJdbctemplate() {
		return jdbctemplate;
	}

	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

}
