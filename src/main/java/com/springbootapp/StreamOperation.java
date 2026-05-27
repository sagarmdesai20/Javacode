package com.springbootapp;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> lst=Arrays.asList("Sagar","Shaurya","Sagar","Raj","Shaurya","Shaurya");
		
		//Find occurances of word in list
		
		Map<String, Long> mp=lst.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
		
		System.out.println("Find occurance of Word in String ");
		mp.entrySet().forEach(System.out::println);
		
		
		String str="sagar";
		//Find occurances of characters in word in list
		
		Map<Character, Long> mp1=str.chars().mapToObj(c->(char) c)
		.collect(Collectors.groupingBy(c->c, Collectors.counting()));
		System.out.println();
		System.out.println("Find occurance of charactets in String ");
		mp1.entrySet().forEach(System.out::println);
		
		//Remove duplicate from list
		
		System.out.println("Remove Duplicate word from List");
		System.out.println("Before removing Duplicates : "+lst);
		List<String> removeDuplicate=lst.stream().distinct().toList();
		System.out.println("After Removing duplicates :"+removeDuplicate);
		
		//Find longest word in list using reduce
		Optional<String> maxStr=lst.stream().reduce((s1,s2)->s1.length()>s2.length()?s1:s2);
		
		System.out.println("Max length Word :"+maxStr);
		
		
		//Find longest word in list using max
		
		String longestWord=lst.stream().max(Comparator.comparing(String::length)).orElse("");
		
		System.out.println("longestWord: "+longestWord);
		
		//Find even and odd number from list
		
		List<Integer> lst1=Arrays.asList(1,2,3,4,5,6,7,8);
		
		Map<Boolean, List<Integer>> mp2=lst1.stream().collect(Collectors.partitioningBy(i->i%2==0));
		
		List<Integer> evenNumber=mp2.get(true).stream().toList();
		
		System.out.println("Even Numbers : "+evenNumber);
		
		List<Integer>oddNumber=mp2.get(false).stream().toList();

		System.out.println("OddNumber :"+oddNumber);
		
		//Reverse the word at same position
		
		String s="Sagar Desai";
		
		String reversseString=Arrays.stream(s.split(" "))
		.map(st-> new StringBuffer(st).reverse().toString())
		.reduce((s1,s2) -> s1+" "+s2).orElse("");
		
		System.out.println("Reverse String :"+reversseString);
		
		//Reverse the word
		String st1="Sagar";
		
		String st2=st1.chars()
		.mapToObj(c->String.valueOf((char) c))
		.reduce("",(sw,c)-> c+sw);
		
		System.out.println("Reverse Single String:"+st2);
		
		//merge two list and remove duplicate
		
		List<Integer> lst3=Arrays.asList(1,3,6,7,4,3);
		List<Integer> lst4=Arrays.asList(1,8,7,4,10);
		
		List<Integer> mergeList=Stream.of(lst3,lst4).flatMap(Collection::stream)
		.distinct()
		.sorted()
		.collect(Collectors.toList());
		
		System.out.println("Two list merged and removed duplicate:"+mergeList);
		
		// merge two list and find  missing numbers
		
		
		int min=mergeList.stream().min(Integer::compare).get();
		int max=mergeList.stream().max(Integer::compare).get();
		
		List<Integer> missingNumbers =IntStream.rangeClosed(min, max)
		.filter(i->!mergeList.contains(i))
		.boxed()
		.collect(Collectors.toList());
		
	System.out.println("Missing number : "+missingNumbers);
	
	//Find common numbers in two list
	
	//option 1
	List<Integer> commonNumber=lst3.stream().filter(i->lst4.contains(i))
	.distinct()
	.collect(Collectors.toList());
	
	List<Integer> commonNumber1=lst3.stream().filter(lst4::contains)
	.distinct()
	.collect(Collectors.toList());
	
	System.out.println("Common Numbers :"+commonNumber);
	System.out.println("Common Numbers :"+commonNumber1);
	
	//find sum 
	
	int sum=lst3.stream().mapToInt(Integer::intValue).sum();
	
	System.out.println("Sum of list :"+sum);
	
	//palindrom
	
	String palstr="aaabaaa";
	
	Boolean resultPal=IntStream.range(0, palstr.length()/2)
	.allMatch(i-> palstr.charAt(i)==palstr.charAt(palstr.length()-1-i));
	
	System.out.println("String is Palindrom aor not :"+resultPal);
	
	//check all numbers are same in array
	
	List<Integer> arr= Arrays.asList(2,2,2,2,2);
	
	boolean countFlag=arr.stream().distinct().count() == 1;
	
	System.out.println("All the elements are duplicate ot not :"+countFlag);
	
	int[] arr1= {2,2,2,2,2};
	
	boolean f=Arrays.stream(arr1).distinct().count()==1;
	
	System.out.println("All the elements are duplicate ot not :"+f);
	
	
	
	
	
	
	
	
	
		
		
		
	}

}


/* Output:
Find occurance of Word in String 
Sagar=2
Raj=1
Shaurya=3

Find occurance of charactets in String 
a=2
r=1
s=1
g=1

Remove Duplicate word from List
Before removing Duplicates : [Sagar, Shaurya, Sagar, Raj, Shaurya, Shaurya]
After Removing duplicates :[Sagar, Shaurya, Raj]

Max length Word :Optional[Shaurya]
longestWord: Shaurya

Even Numbers : [2, 4, 6, 8]
OddNumber :[1, 3, 5, 7]

Reverse String :ragaS iaseD
Reverse Single String:ragaS


Two list merged and removed duplicate:[1, 3, 4, 5, 6, 7, 8, 9]
Missing number : [2, 5, 9]
Common Numbers :[1, 7, 4]
Common Numbers :[1, 7, 4]


Sum of list :24
*/