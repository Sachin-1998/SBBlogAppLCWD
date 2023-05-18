package com.springcore.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Money 
{
	private double amount;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) 
	{
		System.out.println("setting amount");
		this.amount = amount;
	}

	public Money() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Money [amount = " + amount + "]";
	}
	@PostConstruct
	public void init()
	{
		System.out.println("Inside init Money class");
	}
	@PreDestroy
	public void destroy()
	{
		System.out.println("inside destroy money class");
	}
	

}
