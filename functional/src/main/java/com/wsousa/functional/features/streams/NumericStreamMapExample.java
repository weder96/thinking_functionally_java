package com.wsousa.functional.features.streams;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class NumericStreamMapExample {
	
	static double map2Double() {
		return IntStream.rangeClosed(1, 10) // primitive int elements 
				.mapToDouble(x -> x) // converting the elements to double
				.sum(); // performing sum
	}
	
	static long map2Long() {
		return IntStream.rangeClosed(1, 10) // primitive int elements				
				.mapToLong(x -> x) // converting the elements to double
				.sum(); // performing sum
	}
	
	static List<Integer> map2Object(){
		return IntStream.rangeClosed(1, 10).mapToObj(x -> x).collect(Collectors.toList());
				
	}

	public static void main(String[] args) {
		log.info("Map 2 Double : {}",map2Double());
		log.info("Map 2 Long : {}",map2Long());
		log.info("Map 2 Object : {}",map2Object());
	}

}
