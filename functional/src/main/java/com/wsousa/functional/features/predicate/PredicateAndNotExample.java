package com.wsousa.functional.features.predicate;

import com.wsousa.functional.features.repo.Company;
import com.wsousa.functional.features.repo.CompanyRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Predicate;

@Slf4j
public class PredicateAndNotExample {
	public static void main(String[] args) {
		Predicate<Integer> pred1 = num -> num > 25;
		log.info("{} ", pred1.and(Predicate.not(num -> num%2 == 1)).test(30) );
	}
}
