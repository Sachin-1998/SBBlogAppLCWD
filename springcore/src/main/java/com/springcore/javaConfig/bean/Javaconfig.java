package com.springcore.javaConfig.bean;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class Javaconfig
{
	@Bean(name={"mysalary","maxsalary","meansalary"})
	public Salary getSalary()
	{
		Salary salary=new Salary();
		return salary;
	}
	
	@Bean
	public Employee getEmployee()
	{
		//Create obj of Employee
		Employee employee=new Employee();
		return employee;
		
	}
	

}
