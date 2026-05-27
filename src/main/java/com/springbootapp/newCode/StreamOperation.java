package com.springbootapp.newCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//Find Longest String
		String str="Good Morning";

		String longestString=Arrays.stream(str.split(" "))
		.max(Comparator.comparing(String::length)).get().toString();
		
		System.out.println("Longest String :"+longestString);
	
		
		//reverse string without tampering the word position
		
		String reverseString=Arrays.stream(str.split(" "))
		.map(s-> new StringBuilder(s).reverse().toString())
		.reduce((s1,s2)->s1+" "+s2).orElse("");
		
		
		System.out.println("Reverse statement :"+reverseString);
		
		
		
		
		//reverse the statement without reversing the word
		
		String reverseStatement = Arrays.stream(str.split(" "))
		.reduce((s1,s2)->s2+" "+s1).get().toString();
		
		System.out.println("Reverse Statement : "+reverseStatement);
		
		
		//count the occurrences of each word
		
		Map<String, Long> countWord=Arrays.stream(str.split(" "))
		.collect(Collectors.groupingBy(s->s, Collectors.counting()));
		
		countWord.entrySet().stream().forEach(element-> System.out.println("String : "+element.getKey()+" Count: "+element.getValue()));
		
		//count the occurrences of each character by excluding space

		Map<Character, Long> charCount=str.chars().mapToObj(c->(char) c)
		.filter(s-> s!=' ')
		.collect(Collectors.groupingBy(st->st,Collectors.counting() ));
		
		charCount.entrySet().stream().forEach(System.out::println);
		
		//check palindrom
		
		String pal="madam";
		Boolean palindromFlag=IntStream.range(0, pal.length()/2)
		.allMatch(i->pal.charAt(i)==pal.charAt(pal.length()-i-1));
		
		
		
		System.out.println("String is palindrom or not:"+palindromFlag);
		
		int[] arr= {1,2,3,4,8};
		
		int min=Arrays.stream(arr).min().getAsInt();
		int max=Arrays.stream(arr).max().getAsInt();
		
		List<Integer> numbers=Arrays.stream(arr).boxed().collect(Collectors.toList());
		IntStream.rangeClosed(min, max).filter(i->!numbers.contains(i)).boxed()
		.collect(Collectors.toList()).stream().forEach(System.out::println);
		
		int sum=Arrays.stream(arr).sum();
		System.out.println("Sum of Array : "+sum);
		
		int sums=IntStream.rangeClosed(1, 10).sum();
		System.out.println("Sum of Array : "+sums);
		
		int sumEvenNumber=IntStream.rangeClosed(1, 100).filter(i->i%2==0).sum();
		
		System.out.println("Sum of even numbers : "+sumEvenNumber);
		
int sumOddNumber=IntStream.rangeClosed(1, 100).filter(i->i%2!=0).sum();
		
		System.out.println("Sum of odd numbers : "+sumOddNumber);
		
		
		Map<Boolean, List<Integer>> mp=Arrays.stream(arr).boxed().collect(Collectors.partitioningBy(i->i%2==0));
		
		List<Integer> evenNumber=mp.get(true).stream().toList();
		System.out.println("Even Number : "+evenNumber);
		List<Integer> oddNumber=mp.get(false).stream().toList();
		System.out.println("Odd Number : "+oddNumber);
		
		int[] arrs= {1,2,3,3,3,4,5,5};
		List<Integer> arr1=Arrays.stream(arrs).distinct().boxed().toList();
		
		arr1.forEach(System.out::println);
		
		int[] merge=Stream.of(arr,arrs)
				.flatMapToInt(Arrays::stream)
				.boxed()
				.distinct()
				.sorted(Comparator.reverseOrder())
				.mapToInt(Integer::intValue)
				.toArray();
		
	
		
		System.out.println("Merge Array : "+Arrays.toString(merge));
		
		
		
		

		

		
		
	}

}
