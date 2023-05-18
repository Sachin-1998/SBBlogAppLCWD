package com.springrest.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.Dao.CourseDao;
import com.springrest.entities.Course;
@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseDao coursedao;
//	List<Course> list;
	//public CourseServiceImpl() 
//	{
//		
//		list=new ArrayList<>();
//		list.add(new  Course(1, "Core Java", "All about core java"));
//		list.add(new Course(2, "spring boot", "this all about spring boot"));
//    }
	@Override
	public List<Course> getCourse() {
		// TODO Auto-generated method stub
		return coursedao.findAll();
	}
	
	@Override
	public Course getCourseusingId(int courseId) {
//		Course c=null;
//		for(Course course:list)
//		{
//			if(course.getId()==courseid)
//			{
//				c=course;
//				break;
//			}
//		}
		return coursedao.findById(courseId).get();
	}
     
	
	@Override
	public Course addCourse(Course course) {
		//list.add(course);
		return coursedao.save(course);
	}
	@Override
	public Course updateCourse(Course course) 
	{
//		list.forEach(e ->
//		{
//			if(e.getId()==course.getId())
//		         {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//	             }
//		
//		});
		return coursedao.save(course);
	}
	@Override
	public void deleteCourse(int courseid) {
       // list=list.stream().filter(e ->e.getId()!=parselong).collect(Collectors.toList());
		Course c=coursedao.getOne(courseid);
		coursedao.delete(c);

	 }




	



	
	}	
