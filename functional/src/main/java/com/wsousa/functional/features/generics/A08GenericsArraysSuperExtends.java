package com.wsousa.functional.features.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A08GenericsArraysSuperExtends {

	public static void main(String[] args) {

		List<Number> nums = new ArrayList<Number>(); 
		List<? super Number> sink = nums;
		List<? extends Number> source = nums;
		for (int i=0; i<10; i++) 
			sink.add(i);
		
		double sum=0; 
		for (Number num : source) 
			sum+=num.doubleValue();
		
		System.out.println(sum);

		/*Restrictions on Wildcards
Instance creation In a class instance creation expression, if the type
is a parameterized type, none of the type parameters can be wildcards.
*/

//List<?> list = new ArrayList<?>(); // compile-time error
//Map<String, ? extends Number> map = new HashMap<String, ? extends Number>(); // compile-time error
		List<List<?>> lists = new ArrayList<List<?>>(); 
		lists.add(Arrays.asList(1,2,3)); 
		lists.add(Arrays.asList("four","five"));
		assert lists.toString().equals("[[1, 2, 3], [four, five]]");
		System.out.println(lists.toString());

		/*Even though the list of lists is created in a wildcard type, each individual list
		 * inside it has a specific type: the first is a list of integers and the second is a list of strings.
		 * The wildcard type prohibits us from extracting elements from the inner lists like any other type than Object,
		 * but since this is the type used by toString, this code is well written.*/
		List<?> list1 = new ArrayList<Object>(); // ok
		//List<?> list2 = new List<Object>(); // compile-time error 
		//List<?> list3 = new ArrayList<?>(); // compile-time error

	}

}

