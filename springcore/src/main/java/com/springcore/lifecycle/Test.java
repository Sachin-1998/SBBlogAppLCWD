package com.springcore.lifecycle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args)
	{
		//we use AbstractApplicationContext interface to enable pre shutdown hook.or to use destroy method
		//bcz registerShutdownHook method comes under AbstractApplicationContext
		AbstractApplicationContext context=new ClassPathXmlApplicationContext("com/springcore/lifecycle/cycleconfig.xml");
		context.registerShutdownHook();
		Book book=(Book)context.getBean("s1");
		System.out.println(book);
		
		
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		Pen pen=(Pen) context.getBean("p1");
		System.out.println(pen);
		
		
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		Money money=(Money) context.getBean("m1");
		System.out.println(money);
		

	}

}
