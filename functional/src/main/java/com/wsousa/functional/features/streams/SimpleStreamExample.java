package com.wsousa.functional.features.streams;

import com.wsousa.functional.features.repo.Company;
import com.wsousa.functional.features.repo.CompanyRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class SimpleStreamExample {

	public static void main(String[] args) {
		Stream<Integer> s1 = Stream.of(1,2,3,4,5,6);
		s1.forEach(p-> log.info("{}",p));
		log.info("=================");
		Stream<Integer> s2 = Stream.of(new Integer[] {1,2,3,4,5,6,}); 
		s2.forEach(p-> log.info("{}",p));
	}

}
