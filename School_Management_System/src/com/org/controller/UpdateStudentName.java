package com.org.controller;

import com.org.dao.StudentDao;

public class UpdateStudentName {

	public static void main(String[] args) {
		StudentDao dao = new StudentDao();
		boolean res = dao.updateStudentName(102,"Chiku Pattanaik");
		if(res) {
			System.out.println("Data Update Successfully");
		}
		else {
			System.out.println("Data not Upadate");
		}
	}
}
