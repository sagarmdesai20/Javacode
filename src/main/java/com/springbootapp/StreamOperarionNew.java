package com.springbootapp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOperarionNew {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str="Good Morning";
		
		String longestString=Arrays.stream(str.split(" "))
			.max(Comparator.comparing(String::length))
			.orElse("");
		System.out.println("Orginal String :"+str);
		System.out.println("Longest String :"+longestString);
		
		//Reverse statement without reversing word
		
		String reverseStatement=Arrays.stream(str.split(" "))		
		.reduce("",(s1,s2)->s2+" "+s1);
		
		System.out.println("Reverse Statment : "+reverseStatement);
		
		int[] arr= {1,2,4,6,7,9};
		
		int min=Arrays.stream(arr).min().getAsInt();
		int max=Arrays.stream(arr).max().getAsInt();
		
		Set<Integer> numbers=Arrays.stream(arr).boxed().collect(Collectors.toSet());
		
		int[] missingNumbers=IntStream.rangeClosed(min, max)
		.filter(i->!numbers.contains(i))
		.toArray();
		
		System.out.println("Missing numbers in arrays : "+Arrays.toString(missingNumbers));
		
		//count the occurance of vowels in String
		String vowels="aeiou";
		
		String str1="Sagar Desai";
		
		Map<Character, Long>mp=str1.chars().mapToObj(c->(char) c)		
		.filter(c->vowels.indexOf(c)!=-1)
		.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		
		System.out.println("count the occurance of vowels in String");
		mp.entrySet().stream().forEach(System.out::println);
		
		//mp.entrySet().stream().forEach(System.out::println);
		
	}

}


/*O/p:

Orginal String :Good Morning
Longest String :Morning
Reverse Statment : Morning Good 
Missing numbers in arrays : [3, 5, 8]
count the occurance of vowels in String
a=3
e=1
i=1
*/