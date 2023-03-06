package com.org.controller;

import java.util.List;

import com.org.dao.TeacherDao;
import com.org.dto.teacher;

public class getTeacherData {

	public static void main(String[] args) {
		TeacherDao dao = new TeacherDao();
		List<teacher> li = dao.getTeachers();
		System.out.println("TId\tTName\tTSubject\t\tTPhone");
		System.out.println("-----------------------------------------------");
		for(teacher t : li) {
			/* System.out.println("Roll  :"+s.getRoll());
			System.out.println("Name  :"+s.getName());
			System.out.println("Email :"+s.getEmail());
			System.out.println("Age   :"+s.getAge());
			System.out.println("---------------------------------"); */
			
			System.out.println(t.getId()+"\t"+t.getName()+"\t"+t.getSubject()+"\t"+t.getPhone());
		}
}
}
