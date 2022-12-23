package com.wsousa.functional.features.predicate;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Predicate;

@Slf4j
public class PredicateIsEqualsSimple {

	public static void main(String[] args) {
		Predicate<Integer> p2 = Predicate.isEqual(25);
		if (p2.test(25))
			System.out.println("The Predicate is true");
	}
}
