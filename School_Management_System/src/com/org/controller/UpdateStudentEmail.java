package com.org.controller;

import com.org.dao.StudentDao;

public class UpdateStudentEmail {

	public static void main(String[] args) {
		StudentDao dao = new StudentDao();
		boolean res = dao.updateStudentEmail(102,"Chikupattanaik@gmail.com");
		if(res) {
			System.out.println("Data Update Successfully");
		}
		else {
			System.out.println("Data not Upadate");
		}
}
}