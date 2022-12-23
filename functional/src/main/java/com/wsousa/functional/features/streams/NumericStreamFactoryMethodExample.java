package com.wsousa.functional.features.streams;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
@Slf4j
public class NumericStreamFactoryMethodExample {
	public static void main(String[] args) {
		IntStream intStream1 = IntStream.rangeClosed(1, 6);
		IntStream intStream2 = IntStream.range(1, 6);
		intStream1.forEach(i -> log.info(" {}", i));
		log.info("");

		intStream2.forEach(i -> log.info(" {}", i));
		log.info("");

		LongStream.rangeClosed(1, 50).forEach(i -> log.info(" {}", i));
		log.info("");

		LongStream.rangeClosed(1, 50).asDoubleStream().forEach(i -> log.info("{}", i));
		log.info("");

		DoubleStream ds = LongStream.rangeClosed(1, 50).asDoubleStream();
		ds.forEach(i -> log.info(" {}", i));
	}
}
