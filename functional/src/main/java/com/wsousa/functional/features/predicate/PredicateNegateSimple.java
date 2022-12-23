package com.wsousa.functional.features.predicate;

import com.wsousa.functional.features.repo.Company;
import com.wsousa.functional.features.repo.CompanyRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Predicate;

@Slf4j
public class PredicateNegateSimple {

	static Predicate<Integer> pred1 = num -> num > 25;

	public static void main(String[] args) {
		log.info("{} ", pred1.negate().test(30));
	}
}
