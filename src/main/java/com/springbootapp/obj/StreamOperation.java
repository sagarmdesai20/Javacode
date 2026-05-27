package com.springbootapp.obj;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamOperation {
	
	public static void main(String args[])
	{
		
		List<Employee> emp=new ArrayList<>();
		Employee emp1=new Employee(1,"Sagar","Account",25000);
		Employee emp2=new Employee(2,"Shaurya","IT",10000);
		Employee emp3=new Employee(3,"Sagar","Account",15000);
		Employee emp4=new Employee(4,"Sharad","Account",20000);
		
	
		emp.add(emp1);
		emp.add(emp2);
		emp.add(emp3);
		emp.add(emp4);

		//sort employee by name , name same sort by department name , department name same then sort by salary
		emp.stream().sorted(Comparator.comparing(Employee::getEmpName)
				.thenComparing(Employee::getDeptName)
				.thenComparing(Employee::getSalary).reversed()
				).collect(Collectors.toList()).forEach(System.out::println);
		
		//employee group by department name
		Map<String, List<Employee>>empmp=emp.stream().collect(Collectors.groupingBy(Employee::getDeptName));
		
		empmp.entrySet().forEach(System.out::println);
		//salary greater than 10000
		
		emp.stream().filter(e->e.getSalary()>=10000)
		.collect(Collectors.toList()).stream().forEach(System.out::println);
		
		
		
		//find max salary
		
		Employee e=emp.stream().max(Comparator.comparing(Employee::getSalary)).get();
		
		System.out.println("Max Salary : "+e);
		
		//find Max Salary department wise
		
		Map<String, Optional<Employee>> mp1=emp.stream()
		.collect(Collectors.groupingBy(Employee::getDeptName,
				Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
		
		mp1.entrySet().forEach(System.out::println);
		
		}

}
/*output: 
 * List of employees department wise
 * Account=[Employee [empid=3, empName=Raj, deptName=Account, salary=15000.0], Employee [empid=4, empName=Sharad, deptName=Account, salary=20000.0]]
		IT=[Employee [empid=1, empName=Sagar, deptName=IT, salary=5000.0], Employee [empid=2, empName=Shaurya, deptName=IT, salary=10000.0]]
				
				//Salary greater than 100000
				Employee [empid=2, empName=Shaurya, deptName=IT, salary=10000.0]
				Employee [empid=3, empName=Raj, deptName=Account, salary=15000.0]
				Employee [empid=4, empName=Sharad, deptName=Account, salary=20000.0]
				
				//Max salary in all departments
				Max Salary : Employee [empid=4, empName=Sharad, deptName=Account, salary=20000.0]
				
				//Department wise
				Account=Optional[Employee [empid=4, empName=Sharad, deptName=Account, salary=20000.0]]
				IT=Optional[Employee [empid=2, empName=Shaurya, deptName=IT, salary=10000.0]]
				
				*/

