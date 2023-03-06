package com.org.controller;

import com.org.dao.TeacherDao;

public class UpdateTeacherName {

	public static void main(String[] args) {
		TeacherDao dao = new TeacherDao();
		boolean res = dao.updateTeacherName(102,"Ram sagar");
		if(res) {
			System.out.println("Data Update Successfully");
		}
		else {
			System.out.println("Data not Upadate");
		}
	}
}
