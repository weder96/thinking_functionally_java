package com.wsousa.functional.features.predicate;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Predicate;

@Slf4j
public class PredicateTestNullExample {
	static Predicate<String> startPosition = str -> str.length() > 4;
	static Predicate<String> endPosition = str ->str.length() < 10;
	public static void main(String[] args) {
		try {
			log.info(" {}",startPosition.and(endPosition).test(null));
		}
		catch (NullPointerException e) {
			log.info("catch NullPointerException");
		}
	}
}
