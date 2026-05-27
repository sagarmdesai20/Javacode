package com.springbootapp;

public final class FinalClass { //add final keyword - we can not extend(inharitate) the class
	//class variable must be final and private - Variable scope restriction - it will only initialised by constructor and scope within same class
	//Add constuctor to initialised the variable- 
	//Don't create setter method
	
	private final String name;
	private final int age;
	
	public FinalClass(String name, int age) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.age=age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
	
	public void print()
	{
		System.out.println("Name :"+this.name+" Age:"+this.age);
	}
	
	/*
	 * public String print(String name, int age) { this.name=name; //it is not
	 * allowed because variable is final this.age=age; //it is not allowed because
	 * variable is final }
	 */

}
