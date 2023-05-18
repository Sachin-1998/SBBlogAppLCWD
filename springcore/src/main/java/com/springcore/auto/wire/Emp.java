package com.springcore.auto.wire;

import org.springframework.beans.factory.annotation.Autowired;

public class Emp 
{
	
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) 
	{
		this.address = address;
		System.out.println("setting value");
	}

	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emp(Address address) {
		super();
		this.address = address;
		System.out.println("Inside constructor");
	}

	@Override
	public String toString() {
		return "Emp [address=" + address + "]";
	}
	

}
