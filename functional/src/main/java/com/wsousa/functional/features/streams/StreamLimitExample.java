package com.wsousa.functional.features.streams;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
@Slf4j
public class StreamLimitExample {
	public static void main(String[] args) {
		List<String> fruits = Arrays.asList("Apple","Orange","Graphs","Banana","Pineapple");
		fruits.stream().limit(2).forEach(log::info);
		
		List<Integer> integers = Arrays.asList(1,2,3,4,5,6);
		int sum = integers.stream().limit(2).reduce(0,(x,y)-> (x+y));
		log.info("Sum of Limit :"+sum);
		
		int skip = integers.stream().skip(5).reduce(0,(x,y)-> (x+y));
		log.info("Sum of Skip :"+skip);
	}
}
