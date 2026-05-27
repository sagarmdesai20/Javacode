package com.springbootapp.sort;

import java.util.*;

public class ComparatorCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Emp> emp=new ArrayList<>();
		
		Emp e1=new Emp(1,"Sagar",5000);
		Emp e2=new Emp(3,"Shaurya",15000);
		Emp e3=new Emp(2,"Sagar",6000);
		
		
		emp.add(e1);
		emp.add(e2);
		emp.add(e3);
		
		//using java 8 approach
		
		List<Emp> sortedList=emp.stream()
		.sorted(Comparator.comparing(Emp::getEmpName)
				.thenComparing(Emp::getSalary).reversed()
				).toList();
		
		sortedList.stream().forEach(System.out::println);
		
		//before java 8
		
		
		
		
		

	}

}
