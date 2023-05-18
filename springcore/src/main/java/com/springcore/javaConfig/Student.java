package com.springcore.javaConfig;

import org.springframework.stereotype.Component;

@Component("object")
public class Student 
{
	public void study()
	{
		System.out.println("He is studying");
	}

}
