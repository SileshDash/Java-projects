package com.org.controller;

import com.org.dao.StudentDao;

public class DeleteStudent {

	public static void  main(String[] args) {
		StudentDao dao = new StudentDao();
		boolean res = dao.deleteStudent(105);
		if(res) {
			System.out.println("Data Deleted");
		}
		else {
			System.out.println("No data available with specific Id");
		}
	}
}
