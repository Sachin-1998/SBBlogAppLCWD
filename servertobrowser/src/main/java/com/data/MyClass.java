package com.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@ResponseBody
public class MyClass 
{
	@RequestMapping("/mylist")
	ArrayList<Student> list_of_student()
	{
		List<Student> list= new ArrayList<Student> ();
		list.add(new Student(1, "somu", 70));
		list.add(new Student(2, "gomu", 76));
		list.add(new Student(1, "gomu", 84));
		list.add(new Student(1, "gomy", 72));
		return (ArrayList<Student>) list;
	}
	@RequestMapping("/myobj")
	Student get_list()
	{
		Student s=new Student(6, "Sachin", 80);
		return s;
	}

}
