package com.org.controller;

import com.org.dao.StudentDao;

public class UpdateStudentAge {

	public static void main(String[] args) {
		StudentDao dao = new StudentDao();
		boolean res = dao.updateStudentAge(102,17);
		if(res) {
			System.out.println("Data Update Successfully");
		}
		else {
			System.out.println("Data not Upadate");
		}
}
}
