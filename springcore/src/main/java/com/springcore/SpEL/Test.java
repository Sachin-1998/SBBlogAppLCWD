package com.springcore.SpEL;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {

	public static void main(String[] args) throws Exception {
		ApplicationContext context=new ClassPathXmlApplicationContext("com/springcore/SpEL/SpELconfig.xml");
		Demo demo=context.getBean("demo",Demo.class);
		System.out.println(demo);
		
		
//		SpelExpressionParser temp=new SpelExpressionParser();
//	    Expression expression=(Expression) temp.parseExpression("10+10");
//	    System.out.println(expression.getValue());
	}

}
