package com.springJdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.springjdbc.dao.StudentDaoImpl;
import com.springjdbc.dao.Studentdao;

@Configuration
@ComponentScan(basePackages={"com.springjdbc.dao"})
public class javaconfig 
{
	@Bean("ds")
	public DriverManagerDataSource getDataSource()
	{
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://127.0.0.1:3306/springjdbc");
		ds.setUsername("sachin");
		ds.setPassword("password");
		return ds;
	}
	@Bean("jdbcTemplate")
	public JdbcTemplate getJdbcTemplate()
	{
		JdbcTemplate temp=new JdbcTemplate();
		temp.setDataSource(getDataSource());
		return temp;
	}
	
	//with declaring bean
//	@Bean("studentdao")
//	public Studentdao getStudentDao()
//	{
//		StudentDaoImpl s=new StudentDaoImpl();
//		s.setJdbctemplate(getJdbcTemplate());
//		return s;
//		
//	}
	

}
