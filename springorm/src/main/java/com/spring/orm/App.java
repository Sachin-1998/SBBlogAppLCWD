package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.Dao.StudentDao;
import com.spring.orm.entities.Student;


public class App 
{
    public static void main( String[] args )
    {
       ApplicationContext context=new ClassPathXmlApplicationContext("Config.xml");
       StudentDao studentdao=context.getBean("studentDao",StudentDao.class);
      
       System.out.println("welcome to application");
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       boolean go=true;
       while(go)
       {
    	   System.out.println("press 1 to add new student");
    	   System.out.println("press 2 to display1 details of all student");
    	   System.out.println("press 3 to get details of single student");
    	   System.out.println("press 4 to delete single student");
    	   System.out.println("press 5 to update student");
    	   System.out.println("press 6 to exit student");
    	   
    	   try 
    	   {
    		   int input =Integer.parseInt(br.readLine());
    		   switch(input)
    		   {
    		   case 1:
    			   //add new student
//    			   Student s=new Student(3,"gomu","yavatmal");
//    		       int i=studentdao.insert(s);
//    		       System.out.println(i);
//    			   break;
    			   //taking input from user
    			  
    			   System.out.println("Enter student id");
    			   int sId=Integer.parseInt(br.readLine());
    			   
    			   System.out.println("Enter student name");
    			   String sName=br.readLine();
    			   
    			   System.out.println("Enter student city");
    			   String sCity=br.readLine();
    			   
    			   System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    			   //Adding student details 
    			   Student st1=new Student();
    			   st1.setId(sId);
    			   st1.setName(sName);
    			   st1.setCity(sCity);
    			   //calling insert method
    			   int r=studentdao.insert(st1);
    			   System.out.println("Student details added successfully: "+r);
    			   System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    			   System.out.println();
    		   case 2:
    			   //get details of all student
    			   System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    			 List<Student> allStudents=studentdao.getAllStudent();
    			 for(Student s:allStudents)
    			 {
    				 System.out.println("studentId: "+s.getId());
    				 System.out.println("studentName: "+s.getName());
    				 System.out.println("studentCity: "+s.getCity());
    				 System.out.println("________________________________________________________________");
    			 }
    			 System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    			   break;
    		   case 3:
    			   //to get details of single student
    		   	   System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    			   System.out.println("Enter Student Id ");
    			   int sid=Integer.parseInt(br.readLine());
    			   //calling get student method
    			   Student student= studentdao.getStudent(sid);
    			   System.out.println("studentId: "+student.getId());
  				   System.out.println("studentName: "+student.getName());
  				   System.out.println("studentCity: "+student.getCity());
  				   System.out.println("________________________________________________________________");
  				   System.out.println();
     			   System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
     			 
     			   
    			   break;
    		   case 4:
    			   //to delete single student
    			   System.out.println("Enter Student Id ");
    			   int Sid=Integer.parseInt(br.readLine());
    			   studentdao.removeStudent(Sid);
    			   System.out.println("Student deleted");
    			   break;
    		   case 5:
    			   //for update student
    			   System.out.println("Enter Student Id ");
    			   int eid=Integer.parseInt(br.readLine());//enter existing id
    			   
    			   System.out.println("Enter new  name");
    			   String newName=br.readLine();
    			   
    			   System.out.println("Enter new city");
    			   String newCity=br.readLine();
    			   
    			   System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    			   //creating student object 
    			   Student s5=new Student();
    			   s5.setId(eid);
    			   s5.setName(newName);
    			   s5.setCity(newCity);
    			   
    			   //calling update method
    			   Student student5=studentdao.updateStudent(s5);
    			   System.out.println("Student details updated successfully: "+student5);
    			   System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    			   break;
    		   case 6:
    			   //to exit student
    			   
    			   go=false;
    			   break;
    			   
    		   }
    		   
			
		} catch (Exception e) 
    	   {
			System.out.println("Invalid input");
			System.out.println(e.getMessage());
		   }
       }
       System.out.println("thank you for using application");
       
       
      
    }
}
