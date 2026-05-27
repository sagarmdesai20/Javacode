package com.springbootapp.obj;

public class Employee {
	
	private int empid;
	private String empName;
	private String deptName;
	private double salary;
	public Employee(int empid, String empName, String deptName,double salary) {
		super();
		this.empid = empid;
		this.empName = empName;
		this.deptName = deptName;
		this.salary=salary;
	}
	
	public Employee() {
		super();
	}
	
	

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empName=" + empName + ", deptName=" + deptName + ", salary=" + salary
				+ "]";
	}
	
	
	

}
