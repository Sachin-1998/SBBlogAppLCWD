package com.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.entities.Course;
import com.springrest.services.CourseService;

@RestController
public class myController 
{
	@Autowired
	private CourseService courseService;
	@GetMapping("/courses")
	public List<Course> getCourses()
	{
		return this.courseService.getCourse();
	}
	@GetMapping("/courses/{courseid}")
    public Course getCourseById(@PathVariable String courseId)
    {
		return this.courseService.getCourseusingId(Integer.parseInt(courseId));
    	
    }
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course)
	{
		return this.courseService.addCourse( course);
	}
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course)
	{
		return this.courseService.updateCourse(course);
	}
	@DeleteMapping("/courses/{courseid}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable int courseid)
	{
		try {
			this.courseService.deleteCourse(courseid);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
