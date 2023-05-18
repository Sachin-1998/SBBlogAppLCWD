package com.springcore.javaConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ClientMain {

	public static void main(String[] args) 
	{
		ApplicationContext context= new AnnotationConfigApplicationContext(javaConfig.class);
		Student student=context.getBean("object",Student.class);
		System.out.println(student);
		student.study();
		

	}

}
