package com.springcore.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Pen implements InitializingBean,DisposableBean
{
	private double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) 
	{
		System.out.println("setting pen price");
		this.price = price;
	}

	public Pen() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Pen [price=" + price + "]";
	}

	public void afterPropertiesSet() throws Exception {
		
		System.out.println("Inside init: method");
	}

	public void destroy() throws Exception {
		
		System.out.println("Inside destroy: method");
	}
	

}
