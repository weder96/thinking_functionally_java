package com.wsousa.functional.features.streams;

import lombok.extern.slf4j.Slf4j;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

@Slf4j
public class NumericStreamFactoryMethodExample1 {

	public static void main(String[] args) {
		int sum = IntStream.rangeClosed(1, 50).sum();
		log.info("Total is : {}",sum);
		
		OptionalInt max = IntStream.rangeClosed(1, 50).max();
		log.info("Max Value is : {}",max.getAsInt());
		
		OptionalLong min = LongStream.rangeClosed(1, 50).min();
		log.info("Min Value is : {}",min.getAsLong());
		
		OptionalDouble avg = LongStream.rangeClosed(1, 50).average();
		log.info("Average Value is :{}",avg.getAsDouble());
	}

}
