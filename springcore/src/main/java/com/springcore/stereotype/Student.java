package com.springcore.stereotype;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student 
{
	@Value("Alexender")
	private String name;
	@Value("2")
	private int rollNum;
	@Value("Berlin")
	private String city;
	@Value("#{list1}")
	private List<String> addreses;
	@Value("#{set1}")//Spring expression language
	private Set<Integer> marks;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollNum() {
		return rollNum;
	}
	public void setRollNum(int rollNum) {
		this.rollNum = rollNum;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public List<String> getAddreses() {
		return addreses;
	}
	public void setAddreses(List<String> addreses) {
		this.addreses = addreses;
	}
	
	public Set<Integer> getMarks() {
		return marks;
	}
	public void setMarks(Set<Integer> marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", rollNum=" + rollNum + ", city=" + city + ", addreses=" + addreses
				+ ", marks=" + marks + "]";
	}
	
	
	

}
