package com.springjdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springJdbc.entities.Student;

public class RowMapperImpl implements RowMapper<Student>
{

	public Student mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		Student student=new Student();
		student.setId(rs.getInt(1));
		student.setName(rs.getString(2));
		student.setMarks(rs.getInt(3));
		student.setCity(rs.getString(4));
		return student;
	}

}
