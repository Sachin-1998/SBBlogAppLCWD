package com.springcore.auto.wire.annotation;

public class Grade 
{
	private String subject;
	private int marks;
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Grade [subject=" + subject + ", marks=" + marks + "]";
	}
	

}
