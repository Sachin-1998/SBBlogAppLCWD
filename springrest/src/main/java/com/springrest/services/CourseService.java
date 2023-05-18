package com.springrest.services;

import java.util.List;



import com.springrest.entities.Course;


public interface CourseService 
{
	public List<Course> getCourse();
	
	//public Course getCourseById(int cid);
	
	public Course getCourseusingId(int courseId);
	
	public Course addCourse(Course course);
	
	public Course updateCourse(Course course);
	
	public void deleteCourse(
			int courseid);

}
