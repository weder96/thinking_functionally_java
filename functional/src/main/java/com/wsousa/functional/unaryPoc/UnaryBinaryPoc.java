package com.wsousa.functional.unaryPoc;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;
@Slf4j
public class UnaryBinaryPoc {
	static UnaryOperator<String> uo1 = UnaryBinaryPoc::nameUpperCase;
	static UnaryOperator<Integer> uo2 = UnaryBinaryPoc::sumNumber;
	static Comparator<Integer> comp = (a,b) -> a.compareTo(b);

	public static void main(String[] args) {
		log.info("Result 1: "+uo1.apply("java 19"));
		log.info("Result 2: "+uo2.apply(20));
		
		BinaryOperator<Integer> bin01 = BinaryOperator
				.maxBy((a, b) -> (a > b) ? 1 : getCheckNumbers(a, b));
		log.info("Binary Operator MaxBy Result 1: {}", bin01.apply(192, 150));
		
		BinaryOperator<Integer> bin02 = BinaryOperator.maxBy(comp);
		log.info("Binary Operator MaxBy Result 2: {}", bin02.apply(192, 150));
		
		BinaryOperator<Integer> bin03 = BinaryOperator.minBy(comp);
		log.info("Binary Operator MinBy Result 3: {}", bin03.apply(192, 150));
	}

	public static Integer getCheckNumbers(Integer a, Integer b ) {
		return (a.equals(b)) ? 0 : -1;
	}

	private static String nameUpperCase(String name) {
		return name.toUpperCase();
	}

	private static Integer sumNumber(Integer a) {
		return a + 30;
	}
}
