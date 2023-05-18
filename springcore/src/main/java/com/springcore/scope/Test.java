package com.springcore.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) 
	{
		ApplicationContext context= new ClassPathXmlApplicationContext("com/springcore/scope/scopeconfig.xml");
		Car car=context.getBean("car", Car.class);
		System.out.println(car);
		System.out.println(car.hashCode());
		
		Car car1=context.getBean("car", Car.class);
		System.out.println(car1.hashCode());
		
    }

}
