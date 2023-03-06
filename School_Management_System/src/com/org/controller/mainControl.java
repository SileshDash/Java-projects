package com.org.controller;
import java.util.Scanner;

public class mainControl {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("1. for Teacher Data");
		System.out.println("2. for Student Data");
		System.out.println("enter the choice");
		int choice=sc.nextInt();
		TeacherCRUDController teacherCRUDController=new TeacherCRUDController();
		StudentCRUDController studentCRUDController=new StudentCRUDController();
		if (choice==1) {
			teacherCRUDController.Teacher();
		}
		if (choice==2) {
			studentCRUDController.Student();
		}
		else {
			System.out.println("enter the valid option");
			return;
		}
		
	}
	
}
