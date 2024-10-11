package com.spring.orm;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/orm/config.xml");

		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

//		Student student = new Student(12, "Abdul", "Hyd");
//
//		int noOfRowsAffected = studentDao.insert(student);
//		System.out.println("No. of Rows Affected : " + noOfRowsAffected);

		Scanner scan = new Scanner(System.in);
		boolean breakOutOfSwitch = true;

		while (breakOutOfSwitch) {
			System.out.println("Enter 1 to add a new Student");
			System.out.println("Enter 2 to display all Students");
			System.out.println("Enter 3 to display a single Student");
			System.out.println("Enter 4 to delete a Student");
			System.out.println("Enter 5 to update a Student");
			System.out.println("Enter 6 to exit....!!!");

			try {
				int choice = scan.nextInt();

				switch (choice) {
				case 1:
					// add a new student
					System.out.println("Enter user id: ");
					int uId = scan.nextInt();
					System.out.println("Enter user name: ");
					String uName = scan.nextLine();
					scan.next();
					System.out.println("Enter user city: ");
					String uCity = scan.nextLine();
					scan.next();

					Student s = new Student(uId, uName, uCity);
					int noOfUsersAdded = studentDao.insert(s);
					System.out.println("No. of users added: " + noOfUsersAdded);
					break;
				case 2:
					// display all students
					List<Student> allStudents = studentDao.getAllStudents();
					for (Student student : allStudents) {
						System.out.println(student);
					}
					break;
				case 3:
					// display a single student
					break;
				case 4:
					// delete a student
					break;
				case 5:
					// update a student
					break;
				case 6:
					breakOutOfSwitch = false;
					break;

				default:
					break;
				}

			} catch (Exception e) {
				System.out.println("Invalid input, Try with another input");
				System.out.println(e.getMessage());
			}

		}
		System.out.println("Thanks for using this application");
	}
}
