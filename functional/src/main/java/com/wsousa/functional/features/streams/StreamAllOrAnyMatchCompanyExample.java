package com.wsousa.functional.features.streams;

import com.wsousa.functional.features.repo.Company;
import com.wsousa.functional.features.repo.CompanyRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
@Slf4j
public class StreamAllOrAnyMatchCompanyExample {
	static Predicate<Company> p2 = per -> per.getQtyEmployee() >=100000;
	static Predicate<Company> p3 = per -> per.getPositionRanking() <4;

	public static void main(String[] args) {
		log.info("Company All Match : {}", CompanyRepository.getAllCompanies()
		.stream()
		.allMatch(p2));
		
		log.info("Company Any Match : {}" ,CompanyRepository.getAllCompanies()
		.stream()
		.anyMatch(p2.and(p3)));
	}
}
