package com.springbootapp.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Student> students=new ArrayList<>();
		
		Student s1=new Student(1,"Sagar");
		Student s2=new Student(3,"Shaurya");
		Student s3=new Student(2,"Shreyash");
		Student s4=new Student(4,"Akshay");
		
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		
		Collections.sort(students);
		
		print(students);
		
		
		
		

	}
	
	public static void print(List<Student> student)
	{
		System.out.println(student);
	}

}
