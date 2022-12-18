package com.wsousa.functional.features.predicate;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Predicate;
@Slf4j
public class PredicatePoc {
	public static void main(String[] args) {
		Predicate<Integer> lessThan = a -> (a <= 18);
		Predicate<Integer> greaterThan = a -> (a >= 18);
		Predicate<Integer> equalTo = a -> (a == 0);

		boolean result = lessThan.test(18);
		log.info("Result :"+result);

		log.info("Greater Than :"+greaterThan.test(12));
		log.info("Less Than :"+lessThan.test(60));
		log.info("Equal :"+equalTo.test(0));

		boolean result1 = lessThan.and(greaterThan).and(equalTo).test(75);
		log.info("Result 1:"+result1);
		
		boolean result2 = lessThan.or(greaterThan).test(75);
		log.info("Result 2:"+result2);
		
		boolean result3 = lessThan.or(greaterThan).negate().test(75);
		log.info("Result 3:"+result3);
	}
}
