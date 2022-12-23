package com.wsousa.functional.features.streams;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;
@Slf4j
public class StreamFactoryMethodExample {
	static UnaryOperator<Integer> add = x -> x + 5;
	public static void main(String[] args) {
		Stream<Integer> s1 = Stream.iterate(0, add).limit(5);
		s1.forEach(i -> log.info("{} ", i));
		log.info("");

		Stream<Double> s2 = Stream.generate(Math::random).limit(5);
		s2.forEach(i -> log.info("{} ", i));
		log.info("");

		Stream.generate(new Random() :: nextInt).limit(10).forEach(i -> log.info(" {} ", i));
		log.info("");

		Stream<String> s3 = Stream.of("One","Two","Three","Four");
		s3.forEach(s -> log.info(" {} ", s));
	}
}
