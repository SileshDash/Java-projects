package com.org.controller;

import com.org.dao.TeacherDao;
import com.org.dto.teacher;

public class saveTeacher {

	public static void main(String[] args)
	{
		teacher t = new teacher();
		t.setId(101);
		t.setName("Pabitra Pattanaik");
		t.setSubject("Physics");
		t.setPhone(1234567890);
		
		TeacherDao dao = new TeacherDao();
		boolean res = dao.saveTeacher(t);
		if(res) {
			System.out.println("Data Saved Successfully");
		}
		else {
			System.out.println("Data not Saved");
		}
	}
}
