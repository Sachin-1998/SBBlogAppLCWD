package com.springcore.javaConfig.bean;

import org.springframework.beans.factory.annotation.Value;

public class Salary 
{
	@Value("32000")
	private double salary;

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Salary [salary=" + salary + "]";
	}
	
	

}
