package com.validateapi;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;


@Validated
public class Student 
{
	
	@NotNull(message="name should not be null")
	private String name;
	@Min(value=18, message="age should not be more than 18")
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
