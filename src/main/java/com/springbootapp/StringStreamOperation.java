package com.springbootapp;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Optional;
import java.util.stream.Collectors;

public class StringStreamOperation {

	public static void main(String args[])
	{
		
		String str="aabbcdde";
		
		Character result=str.chars()
		.mapToObj(c->(char) c)
		.collect(Collectors.groupingBy(
				c->c,
				LinkedHashMap::new,
				Collectors.counting()
				))
		.entrySet()
		.stream()
		.filter(f->f.getValue()==1)
		.map(f->f.getKey())
		.findFirst().orElse(null);
		
		
		System.out.println("First non repeating character :"+result);
		
	}
}

