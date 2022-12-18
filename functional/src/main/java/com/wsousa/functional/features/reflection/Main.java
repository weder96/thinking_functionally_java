package com.wsousa.functional.features.reflection;

import java.util.ArrayList;
import java.util.List;

public class Main {
	

	public static void main(String[] args) {
		Class<Integer> ki = Integer.class; 
		Number n = Integer.valueOf(42);
		Class<? extends Number> kn = n.getClass(); 
		
		assert ki == kn;
		
		
		Class ki2 = Integer.class; 
		Number n2 = Integer.valueOf(42);
		Class kn2 = n2.getClass(); 
		
		assert ki2 == kn2;
		
		
		List<Integer> ints = new ArrayList<Integer>();
		List<String> strs = new ArrayList<String>(); 
		assert ints.getClass() == strs.getClass(); 
		assert ints.getClass() == ArrayList.class;
		
		
		
		List<Integer> ints2 = new ArrayList<Integer>(); 
		Class<? extends List> k = ints2.getClass(); 
		assert k == ArrayList.class;
		
		//public Class<?> k = List<Integer>.class; 
		// syntax error 


	}

}

/*
		Reflection is the term for a set of features that allow a program to examine its own definition.
		Reflection in Java plays a role in class browsers, object inspectors, debuggers, interpreters, services like JavaBeansTM and
		object serialization, and any tool that creates, inspects, or manipulates arbitrary Java objects on the fly.
		Reflection has been present in Java since the beginning, but the advent of generics changes reflection in two important ways,
		introducing generics to reflection and reflection to generics.


class Class<T> {
    public T newInstance();
	public T cast(Object o);
	public Class<? super T> getSuperclass();
	public <U> Class<? extends U> asSubclass(Class<U> k);
	public <A extends Annotation> A getAnnotation(Class<A> k);
	public boolean isAnnotationPresent(Class<? extends Annotation> k);
	}
*/

