package com.wsousa.functional.features.biConsumerPoc;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class BiConsumerPoc {

	public static void main(String[] args) {
		java.util.function.BiConsumer<Integer, Integer> con1 = (a, b) -> log.info("Add :"+(a+b));
		con1.accept(10, 20);

		List<Integer> list1 = Arrays.asList(Integer.valueOf(10), Integer.valueOf(10), Integer.valueOf(10));
		List<Integer> list2 = Arrays.asList(Integer.valueOf(10), Integer.valueOf(10));

		java.util.function.BiConsumer<List<Integer>,List<Integer>> con2 = (l1, l2) -> {
			if(l1.size() == l2.size()) log.info("True");
			else log.info("False");
		};
		con2.accept(list1, list2);

		java.util.function.BiConsumer<Integer, Integer> addConsumer = (a, b) -> log.info("Add :"+(a+b));
		java.util.function.BiConsumer<Integer, Integer> subConsumer = (a, b) -> log.info("Subs :"+(a-b));
		java.util.function.BiConsumer<Integer, Integer> mulConsumer = (a, b) -> log.info("Mul :"+(a*b));
		addConsumer.accept(10, 20);
		subConsumer.accept(10, 20);
		mulConsumer.accept(10, 20);
		addConsumer.andThen(subConsumer).andThen(mulConsumer).accept(10, 20);

	}

}
