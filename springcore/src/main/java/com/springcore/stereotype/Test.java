package com.springcore.stereotype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) 
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("com/springcore/stereotype/stereoconfig.xml");
		Student s=context.getBean("student", Student.class);
		System.out.println(s);
		System.out.println(s.getAddreses());
		System.out.println(s.getMarks());
		System.out.println(s.getAddreses().getClass().getName());
		System.out.println(s.getMarks().getClass().getName());

	}

}
