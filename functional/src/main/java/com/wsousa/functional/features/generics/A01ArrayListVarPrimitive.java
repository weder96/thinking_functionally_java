package com.wsousa.functional.features.generics;

import java.util.ArrayList;
import java.util.List;

public class A01ArrayListVarPrimitive {
	Character d='w';
	char dea='d';

	//An interface or class can be declared to take one or more parameters
	// of type, which are written
	//In angle brackets and must be provided when you declare a variable
	// belonging to the interface or class
	//Or when you create a new instance of a class.
	public static void main(String[] args) {
		List<String> words = new ArrayList<String>(); 
		words.add("Hello ");
		words.add("world!");
		String s = words.get(0)+words.get(1);
		System.out.println(s);
		assert s.equals("Hello world!");

	}

}
/*
 *  
Primitive       References
byte 			Byte
short 			Short
int 			Integer
long 			Long
float 			Float
double 			Double
boolean 		Boolean
char 			Character
*/
