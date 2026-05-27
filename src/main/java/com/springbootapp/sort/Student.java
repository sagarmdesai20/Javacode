package com.springbootapp.sort;


public class Student implements Comparable{
	
	int studentid;
	String studentName;
	
	
	
	public Student(int studentid, String studentName) {
		super();
		this.studentid = studentid;
		this.studentName = studentName;
	}
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	
	@Override
	public String toString() {
		return "Student [studentid=" + studentid + ", studentName=" + studentName + "]";
	}
	
	//Sort student albhatical order in ascending
	/*
	 * @Override public int compareTo(Object o) { // TODO Auto-generated method stub
	 * Student s=(Student) o; return this.studentName.compareTo(s.studentName); }
	 */
	
	//Sort student albhatical order in descending	
	/*
	 * @Override public int compareTo(Object o) { // TODO Auto-generated method stub
	 * Student s=(Student) o; return s.studentName.compareTo(this.studentName); }
	 */
	
	
	//sort in descending order
	/*
	 * @Override public int compareTo(Object o) { // TODO Auto-generated method stub
	 * Student s=(Student) o; if(this.studentid>s.studentid) { return -1; } else
	 * if(this.studentid<s.studentid) { return 1; }else return 0; }
	 */	
	
	//sort in ascending order
	
	  @Override public int compareTo(Object o) { // TODO Auto-generated method stub
	  Student s=(Student) o; if(this.studentid>s.studentid) { return 1; } else
	  if(this.studentid<s.studentid) { return -1; }else return 0; }
	 

	
	
	

}
