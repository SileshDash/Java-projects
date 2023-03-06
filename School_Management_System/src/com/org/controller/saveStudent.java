package com.org.controller;

import com.org.dao.StudentDao;
import com.org.dto.student;

public class saveStudent {

	public static void main(String args[]) {
		student s = new student();
		s.setRoll(102);
		s.setName("Chiku");
		s.setEmail("Chiku@gmail.com");
		s.setAge(11);
		
		StudentDao dao = new StudentDao();
		boolean res = dao.saveStudent(s);
		if(res) {
			System.out.println("Data Saved Successfully");
		}
		else {
			System.out.println("Data not Saved");
		}
	}
}
