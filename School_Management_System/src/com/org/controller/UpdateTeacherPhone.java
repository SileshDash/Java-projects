package com.org.controller;

import com.org.dao.TeacherDao;

public class UpdateTeacherPhone {

	public static void main(String[] args) {
		TeacherDao dao = new TeacherDao();
		boolean res = dao.updateTeacherPhone(103,1111111111);
		if(res) {
			System.out.println("Data Update successfully");
		}else {
			System.out.println("Data not Update");
		}
	}
}
