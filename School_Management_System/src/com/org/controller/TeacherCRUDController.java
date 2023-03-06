package com.org.controller;

import java.util.List;
import java.util.Scanner;
import com.org.dao.TeacherDao;
import com.org.dto.teacher;
public class TeacherCRUDController {

	public static void Teacher() {
		Scanner sc = new Scanner(System.in);
		TeacherDao dao = new TeacherDao();
		
		while(true) {
			System.out.println("*-*-*-*-|| MENU ||-*-*-*-*");
			System.out.println("Enter 1. For Add Teacher Data");
			System.out.println("Enter 2. For View Teacher Data");
			System.out.println("Enter 3. For Delete Teacher Data");
			System.out.println("Enter 4. For Update Teacher Data");
			System.out.println("Enter 5. For Exit");
			System.out.println("Please Enter your Choice =");
			int ch = sc.nextInt();
			switch(ch) {
			//For Add New Data
			case 1:{
				System.out.println("Enter Teacher Id Number =");
				int Id = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Teacher Name =");
				String name = sc.nextLine();
				System.out.println("Enter subject of Teacher =");
				String subject = sc.nextLine();
				System.out.println("Enter Teacher Phone No. =");
				int phone = sc.nextInt();
				
				teacher t = new teacher();
				t.setId(Id);
				t.setName(name);
				t.setSubject(subject);
				t.setPhone(phone);
				
				boolean res = dao.saveTeacher(t);
				if(res) {
					System.out.println(name+" Data Stored Successfully");
				}else {
					System.out.println("Something went wrong please try again !!!!!!");
				}
			}break;
			//For View Teacher Data
			case 2:{
				List<teacher> list = dao.getTeachers();
				for (teacher teacher : list) {
					System.out.println("id       :" + teacher.getId());
					System.out.println("name     :" + teacher.getName());
					System.out.println("subject  :" + teacher.getSubject());
					System.out.println("phone    :" + teacher.getPhone());
					System.out.println("-----------------------------------------");
				}
				
			}break;
			//For Delete Teacher Data
			case 3:{
				System.out.println("Enter the Teacher id you want to delete");
				int id = sc.nextInt();
				if (dao.deleteTeacher(id)) {
					System.out.println("Deleted successfully");
				} else {
					System.out.println("no data availavle in specific id");
				}
				
			}break;
			//For Update Teacher Data
			case 4:{
				System.out.println("a) For update teacher name");
				System.out.println("b) For update teacher subject");
				System.out.println("c) For update teacher phone");
				System.out.println("d) For update all details");
				char character = sc.next().charAt(0);
				switch (character) {
				case 'a': {
					System.out.println("Enter the teacher id");
					int id = sc.nextInt();
					sc.nextLine();
					System.out.println("Enter the new name for update");
					String name = sc.nextLine();
					boolean res = dao.updateTeacherName(id, name);
					if (res) {
						System.out.println("Name Update Successfully");
					}
					else {
						System.out.println("Somthing went wrong please enter correctly!!!!!");
					}
			}break;
				case 'b': {
					System.out.println("Enter the teacher id");
					int id = sc.nextInt();
					sc.nextLine();
					System.out.println("Enter the new subject for update");
					String subject = sc.nextLine();
					boolean res = dao.updateTeacherName(id, subject);
					if (res) {
						System.out.println("Subject Update Successfully");
					}
					else {
						System.out.println("Somthing went wrong please enter correctly!!!!!");
					}
				}
					break;
				case 'c': {
					System.out.println("Enter the teacher id");
					int id = sc.nextInt();
					System.out.println("Enter the update phone number");
					int phone = sc.nextInt();
					boolean res = dao.updateTeacherPhone(id, phone);
					if (res) {
						System.out.println("Phone number update successfully");
					}else {
						System.out.println("somthing went wrong please enter correctly");
					}
				}
					break;
				case 'd': {
					System.out.println("Enter the teacher id");
					int id = sc.nextInt();
					sc.nextLine();
					System.out.println("Enter the new name for update");
					String name = sc.nextLine();
					System.out.println("Enter the new subject for update");
					String subject = sc.nextLine();
					System.out.println("Enter the phone number for update");
					int phone = sc.nextInt();
					boolean res = dao.updateAllDeatiled(id, name, subject, phone);
					if (res) {
						System.out.println("Phone number update successfully");
					}else {
						System.out.println("somthing went wrong please enter correctly");
					}
				}
			//For Exit From Loop
			case 5:{
				 dao.closeConnection();
				sc.close();
				System.out.println("\nExist Successfully\n");
			}
				return ;
			}
			}
		}
	}
	}
}
