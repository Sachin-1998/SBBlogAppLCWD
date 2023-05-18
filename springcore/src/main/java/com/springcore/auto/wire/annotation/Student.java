package com.springcore.auto.wire.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Student 
{
	@Autowired
	@Qualifier("grade")
	private Grade grade;

	public Grade getGrade() {
		return grade;
	}
	
	public void setGrade(Grade grade) {
		this.grade = grade;
		System.out.println("setting grade");
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Student(Grade grade) {
		super();
		this.grade = grade;
		System.out.println("inside constructor");
	}

	@Override
	public String toString() {
		return "Student [grade=" + grade + "]";
	}
	

}
