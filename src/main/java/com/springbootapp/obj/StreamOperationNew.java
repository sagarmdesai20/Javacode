package com.springbootapp.obj;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamOperationNew {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		List<Employees> emp=new ArrayList<>();
		
		Employees emp1=new Employees(1,"Sagar",5000,1);
		Employees emp2=new Employees(2,"Shaurya",10000,1);
		Employees emp3=new Employees(3,"Raj",15000,2);
		Employees emp4=new Employees(4,"Sharad",20000,3);
		Employees emp5=new Employees(5,"Kavya",25000,3);
		
	
		emp.add(emp1);
		emp.add(emp2);
		emp.add(emp3);
		emp.add(emp4);
		emp.add(emp5);
		
		List<Department> dept=new ArrayList<>();
		
		Department d1=new Department(1,"IT");

		Department d2=new Department(2,"Account");
		
		Department d3=new Department(3,"Sale");
		
		dept.add(d1);
		dept.add(d2);
		dept.add(d3);
		
		//Map<Integer, List<Employees>> empList=emp.stream().collect(Collectors.groupingBy(Employees::getDeptId));
		
		//empList.entrySet().stream().forEach(System.out::println);
		
		
		/*
		 * Map<Integer,
		 * String>deptMap=dept.stream().collect(Collectors.toMap(Department::getDeptId,
		 * Department::getDepartmentName));
		 * 
		 * String s=emp.stream(). max(Comparator.comparingDouble(Employees::getSalary))
		 * .map(empl->deptMap.getOrDefault(empl.getDeptId(),"Unknonw Department")).
		 * orElse("Employee not Found"); System.out.println(s);
		 */
		
		
		Map<Integer, String> deptMap = dept.stream()
	            .collect(Collectors.toMap(Department::getDeptId, Department::getDepartmentName));

	        // Step 2: Use Stream API to group by DeptId and find max salary
	        //Map<String, Optional<Employees>> highestSalaryByDept = 
	      
		
		
		Map<Object, Optional<Employees>> highestSalaryDepartmentWise= emp.stream()
		.collect(
				Collectors.groupingBy(
						ep->deptMap.get(ep.getDeptId())
						,Collectors.maxBy(Comparator.comparingDouble(Employees::getSalary))
						)
				
				);
		
		highestSalaryDepartmentWise.forEach((deptName,employees) ->
		System.out.println("Department Name : "+deptName+" | Employee Name : "+employees.map(Employees::getEmpName).orElse("N/A")
				+" | Max Salary : "+employees.map(Employees::getSalary).orElse(0.0)));
		
	}

}
/*
 * Having Employee and Department classes, find max salary departmentwise
 * 
 * Department Name : Sale | Employee Name : Kavya | Max Salary : 25000.0
Department Name : Account | Employee Name : Raj | Max Salary : 15000.0
Department Name : IT | Employee Name : Shaurya | Max Salary : 10000.0
 */
