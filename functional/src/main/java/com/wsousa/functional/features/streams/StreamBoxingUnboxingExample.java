package com.wsousa.functional.features.streams;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
@Slf4j
public class StreamBoxingUnboxingExample {
	static List<Integer> boxingMethod(){
		return IntStream.rangeClosed(1, 10) // primitive int
				.boxed() // converting to wrapper Integer
				.collect(Collectors.toList()); // collect as List
	}
	static int calculateSum(List<Integer> list) {
		return list.stream()
				.mapToInt(Integer :: intValue) // Map do the converting part 
				.sum(); // performing sum operation
	}
	public static void main(String[] args) {
		boxingMethod().forEach(i -> log.info(" {}", i));
		log.info("Sum is :"+calculateSum(boxingMethod()));
	}
}
