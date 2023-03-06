package com.org.controller;

import com.org.dao.TeacherDao;

public class DeleteTeacher {

	public static void main(String[] args) {
		TeacherDao dao = new TeacherDao();
		boolean res = dao.deleteTeacher(101);
		if(res) {
			System.out.println("Data Deleted");
		}
		else {
			System.out.println("No data available with specific Id");
		}
		}
	}
