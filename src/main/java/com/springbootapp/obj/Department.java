package com.springbootapp.obj;

public class Department {
	
	private int deptId;
	private String departmentName;
	public Department(int deptId, String departmentName) {
		super();
		this.deptId = deptId;
		this.departmentName = departmentName;
	}
	public Department() {
		super();
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", departmentName=" + departmentName + "]";
	}
	
	

}
