package com.wsousa.functional.features.functionPoc;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;

@Slf4j
public class FunctionPoc {
	
	static Function<String, String> function1 = name -> name.toUpperCase();
	static Function<String, String> function2 = name -> name.toUpperCase().concat(" features");

	public static void main(String[] args) {
		log.info("Result 1: "+function1.apply("java"));
		log.info("Result 2: "+function1.apply("java"));
		log.info("And Then Result :"+ function1.andThen(function2).apply("java"));
		log.info("Compose Result :"+function1.compose(function2).apply("java"));
	}
}
