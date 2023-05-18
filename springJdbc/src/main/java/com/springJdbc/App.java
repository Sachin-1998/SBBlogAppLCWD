package com.springJdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springJdbc.entities.Student;
import com.springjdbc.dao.Studentdao;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(javaconfig.class);
		Studentdao studentdao = context.getBean("studentdao", Studentdao.class);
		System.out.println(" Welcome to JDBC CRUD Application ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		boolean go = true;
		while (go) {

			System.out.println("Press 1 to Add Student Details..");
			System.out.println("Press 2 to Update Student Details");
			System.out.println("Press 3 to Delete Student Details");
			System.out.println("Press 4 to get Student by Student Id");
			System.out.println("Press 5 to get All Students");
			System.out.println("Press 6 to exit Application");

			try {
				int input = Integer.parseInt(br.readLine());
				switch (input) {
				case 1:
					// for insert
					Student student1 = new Student();
					// System.out.println("Enter student Details to add");

					System.out.println("Enter student id to add: ");
					int id = Integer.parseInt(br.readLine());
					System.out.println("Enter student name to add: ");
					String name = br.readLine();
					System.out.println("Enter student city to add: ");
					String city = br.readLine();
					System.out.println("Enter student marks to add: ");
					int marks = Integer.parseInt(br.readLine());
					student1.setId(id);
					student1.setName(name);
					student1.setCity(city);
					student1.setMarks(marks);

					int addStudent = studentdao.insert(student1);
					System.out.println("Student Data Added successfully: " + addStudent);
					break;

				case 2:
					// update student
					Student student2 = new Student();

					System.out.println("enter Student Id: ");
					int sid = Integer.parseInt(br.readLine());
					System.out.println("Enter the name :");
					String sname = br.readLine();
					System.out.println("Enter the marks:");
					int smarks = Integer.parseInt(br.readLine());
					System.out.println("Enter the city: ");
					String scity = br.readLine();

					student2.setId(sid);
					student2.setName(sname);
					student2.setMarks(smarks);
					student2.setCity(scity);
					int updateStudent = studentdao.change(student2);
					System.out.println("Student Data Updated successfully: " + updateStudent);
					break;
				case 3:
					// delete student
					Student student3 = new Student();

					int dresult = Integer.parseInt(br.readLine());
					int deletedStudent = studentdao.delete(dresult);
					System.out.println("the Student Deleted Successfully : " + deletedStudent);
					break;
				case 4:
					// get particular Student
					System.out.println("Enter student Id");
					int existingId = Integer.parseInt(br.readLine());
					Student student4 = studentdao.getStudent(existingId);
					System.out.println(" Stduent : " + student4);
					break;
				case 5:

					// getting all student
					List<Student> s2 = studentdao.getAllStudents();
					for (Student s : s2) {
						System.out.println("The List Of All Student: " + s);
					}
					break;
				case 6:
					go = false;
					break;

				}

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Invalid input: " + e.getMessage());
			}
		}
		System.out.println("Thank you For Using Application..");
		/**
		 * JdbcTemplate template=context.getBean("jdbcTemplate",JdbcTemplate.class);
		 * //insert query String query="insert into Student() values(?,?,?,?)"; //fire
		 * query int record=template.update(query,3,"Rahul",97,"Beed");
		 * System.out.println("the number of record inserted: "+record);
		 */
	}
}
