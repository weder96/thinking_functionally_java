package com.wsousa.functional.features.bipredicate;

import lombok.extern.slf4j.Slf4j;

import java.util.function.BiPredicate;

@Slf4j
public class BiPredicateSimple {
	static BiPredicate<String, Integer> biPred = (str, num) -> str.equals("Developer") && num > 80000;
	public static void main(String[] args) {
		String position = "Developer";
		int salary = 100000;
		log.info("test: {} ",biPred.test(position,salary));
	}
}
