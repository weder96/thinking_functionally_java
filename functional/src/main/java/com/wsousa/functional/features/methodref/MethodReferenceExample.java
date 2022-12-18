package com.wsousa.functional.features.methodref;

import java.util.Comparator;

public class MethodReferenceExample {
	// Classname :: methodName
	public static void main(String[] args) {
		System.out.println("Result 1 :"+MethodReferenceExample.compare(50, 60));
		Comparator<Integer> comp =  MethodReferenceExample::compare;
		System.out.println("Result 2:"+comp.compare(50, 60));
	}
	public static int compare(Integer x,Integer y) {
		return Integer.compare(x, y);
	}
}
