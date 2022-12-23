package com.wsousa.functional.features.streams;

import com.wsousa.functional.features.repo.Company;
import com.wsousa.functional.features.repo.CompanyRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
@Slf4j
public class StreamAllOrAnyMatchExample {
	
	static Predicate<String> p1 = num -> num.length() > 7;

	public static void main(String[] args) {
		List<String> fruits = Arrays.asList("Apple","Orange","Graphs","Banana","Pineapple");
		log.info("Length Check All Match: {}",fruits.stream().allMatch(p1));
		log.info("Length Check Any Match: {}",fruits.stream().anyMatch(p1));
	}

}
