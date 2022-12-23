package com.wsousa.functional.features.streams;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
@Slf4j
public class StreamReduceExample {
	public static void main(String[] args) {
		List<Integer> listofIntegers = Arrays.asList(1,2,3,4,5);
		int sum = listofIntegers.stream().mapToInt(i -> i).sum();
		log.info("Sum Result : {} ",sum);
		log.info("Count Result {} ",listofIntegers.stream().mapToInt(i -> i).count());
		
		log.info("Result of Multiplication : {} ", listofIntegers.stream().reduce(1, (a,b) -> a*b));
		log.info("Result of Addition : {} ", listofIntegers.stream().reduce(0, (a,b) -> a+b));
	}
}

// 1*1 = 1
// 1*2 = 2
// 2*3 = 6
// 6*4 = 24
// 24*5 = 120