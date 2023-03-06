package com.org.controller;

import java.util.List;

import com.org.dao.StudentDao;
import com.org.dto.student;

public class getStudentData {

	public static void main(String[] args) {
		StudentDao dao = new StudentDao();
		List<student> li = dao.getStudents();
		System.out.println("SRoll\tSName\tSEmail\t\tSAge");
		System.out.println("-----------------------------------------------");
		for(student s : li) {
			/* System.out.println("Roll  :"+s.getRoll());
			System.out.println("Name  :"+s.getName());
			System.out.println("Email :"+s.getEmail());
			System.out.println("Age   :"+s.getAge());
			System.out.println("---------------------------------"); */
			
			System.out.println(s.getRoll()+"\t"+s.getName()+"\t"+s.getEmail()+"\t"+s.getAge());
		}
	}
}
