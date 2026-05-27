package com.springbootapp.obj;

public class Employees {

	private int empId;
	private String empName;
	private double salary;
	private int deptId;
	public Employees() {
		super();
	}
	public Employees(int empId, String empName, double salary, int deptId) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
		this.deptId = deptId;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	@Override
	public String toString() {
		return "Employees [empId=" + empId + ", empName=" + empName + ", salary=" + salary + ", deptId=" + deptId + "]";
	}
	
	
	
}
