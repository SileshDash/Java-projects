package com.org.controller;

import java.util.List;
import java.util.Scanner;

import com.org.dao.StudentDao;
import com.org.dto.student;

public final class StudentCRUDController {

	public static void Student() {
		Scanner sc = new Scanner(System.in);
		StudentDao dao = new StudentDao();
//While Loop For Infinite Looping
		while(true) {
			System.out.println("*-*-*-*-|| MENU ||-*-*-*-*");
			System.out.println("Enter 1. For Add Student Data");
			System.out.println("Enter 2. For View Student Data");
			System.out.println("Enter 3. For Delete Student Data");
			System.out.println("Enter 4. For Update Student Data");
			System.out.println("Enter 5. For Exit");
			System.out.println("Please Enter your Choice =");
			int ch = sc.nextInt();
			
			switch(ch) {
			//For Add New Data
			case 1:{
				System.out.println("Enter Student Roll Number =");
				int roll = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Student Name =");
				String name = sc.nextLine();
				System.out.println("Enter Student Email =");
				String email = sc.nextLine();
				System.out.println("Enter Student Age =");
				int age = sc.nextInt();
				
				student s = new student();
				s.setRoll(roll);
				s.setName(name);
				s.setEmail(email);
				s.setAge(age);
				
				boolean res = dao.saveStudent(s);
				if(res) {
					System.out.println(name+" Data Stored Successfully");
				}else {
					System.out.println("Something went wrong please try again !!!!!!");
				}
			}break;
			case 2:{
				List<student> li = dao.getStudents();
				for(student s : li) {
					System.out.println("Roll  :"+s.getRoll());
					System.out.println("Name  :"+s.getName());
					System.out.println("Email :"+s.getEmail());
					System.out.println("Age   :"+s.getAge());
					System.out.println("---------------------------------");
				}
			}break;
			//For Delete Student Data
			case 3:{
			System.out.println("Enter Student Roll Number for Deleting the Data = ");
			int roll=sc.nextInt();
			boolean res = dao.deleteStudent(roll);
			if(res) {
				System.out.println("Data Deleted Successfully");
			}
			else {
				System.out.println("No data available with specific Id");
			}
			}break;
			//For Update Student Data
			case 4:{
				System.out.println("*-*-*-*-|| MENU ||-*-*-*-*");
				System.out.println("Enter a. For Updating Name Student");
				System.out.println("Enter b. For Updating Email Student");
				System.out.println("Enter c. For Updating Age of Student");
				System.out.println("Enter d. For Updating all Student Data");
				System.out.println("Please Enter your Choice =");
				char c = sc.next().charAt(0);
				
				switch(c) {
				//Update the Name Only
				case 'a' :{
				System.out.println("Enter the Roll Number of Student =");
				int roll = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter the new Name to Update =");
				String name=sc.nextLine();
				boolean res =dao.updateStudentName(roll, name);
				if(res) {
					System.out.println("Name Update Successfully");
				}else {
					System.out.println("Something went wrong Name not Updated");
				}
				}
				//Update the Email Only
				case 'b' :{
					System.out.println("Enter the Roll Number of Student =");
					int roll = sc.nextInt();
					sc.nextLine();
					System.out.println("Enter the new Email to Update =");
					String email = sc.nextLine();
					boolean res = dao.updateStudentEmail(roll, email);
					if(res) {
						System.out.println("Email Update Successfully");
					}else {
						System.out.println("Something went wrong Email not Updated");
					}
					}
				//Update The Age only
				case 'c' :{
					System.out.println("Enter the Roll Number of Student =");
					int roll = sc.nextInt();
					sc.nextLine();
					System.out.println("Enter the new Age to Update =");
					int age=sc.nextInt();
					boolean res =dao.updateStudentAge(roll, age);
					if(res) {
						System.out.println("Age Update Successfully");
					}else {
						System.out.println("Something went wrong Age not Updated");
					}
					}
				//Update All Detailed at a time
				case 'd' :{
					System.out.println("Enter the Roll Number of Student =");
					int roll = sc.nextInt();
					sc.nextLine();
					System.out.println("Enter the new Name to Update =");
					String name=sc.nextLine();
					System.out.println("Enter the new Email to Update =");
					String email = sc.nextLine();
					System.out.println("Enter the new Age to Update =");
					int age=sc.nextInt();
					boolean res =dao.updateAllDetails(roll, name, email, age);
					if(res) {
						System.out.println("Student Data Update Successfully");
					}else {
						System.out.println("Something went wrong Student Data not Updated");
					}
					}
				}
			}break;
			//For Exit From Loop
			case 5:{
				dao.closeConnection();
				return ;
			}
			}
		}
	}
}
