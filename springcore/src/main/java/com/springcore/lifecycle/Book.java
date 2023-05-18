package com.springcore.lifecycle;

public class Book {

	private int Price;

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) 
	{
		System.out.println("setting price");
		Price = price;
	}
	

	public Book(int price) {
		super();
		Price = price;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Book [Price = " + Price + "]";
	}
	public void init()
	{
		System.out.println("Inside init Book class");
	}
	public void destroy()
	{
		System.out.println("Inside destroy Book class");
	}
	
	

}
