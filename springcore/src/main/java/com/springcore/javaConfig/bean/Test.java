package com.springcore.javaConfig.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(Javaconfig.class);
		Employee employee=context.getBean("getEmployee",Employee.class);
		System.out.println(employee);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
		Salary salary=context.getBean("mysalary",Salary.class);
		System.out.println(salary);
		System.out.println(salary.getSalary());
	}

}
