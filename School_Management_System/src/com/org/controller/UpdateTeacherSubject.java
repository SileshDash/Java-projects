package com.org.controller;

import com.org.dao.TeacherDao;

public class UpdateTeacherSubject {

	public static void main(String[] args) {
		TeacherDao dao = new TeacherDao();
		boolean res = dao.updateTeacherSubject(103,"Mathematrics");
		if(res) {
			System.out.println("Data Update successfully");
		}else {
			System.out.println("Data not updated");
		}	
	}
}
