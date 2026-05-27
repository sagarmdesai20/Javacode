package com.springbootapp;

public class ChildClass //extends FinalClass{ // if we extend final class it will not allowed
{
	public static void main(String[] args)
	{
		FinalClass f=new FinalClass("Sagar", 37);
		//f.name="Shaurya"; // if name and age are not private and final then we can change value
		//f.age=7;
		f.print();
	}
}
