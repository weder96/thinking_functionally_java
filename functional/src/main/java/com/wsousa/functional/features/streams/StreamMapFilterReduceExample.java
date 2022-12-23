package com.wsousa.functional.features.streams;

import com.wsousa.functional.features.repo.Company;
import com.wsousa.functional.features.repo.CompanyRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Predicate;
@Slf4j
public class StreamMapFilterReduceExample {
	
	static Predicate<Company> p1 = (per) -> per.getQtyEmployee() >=140 ;
	static Predicate<Company> p2 = (per) -> per.getName().equals("Apple");

	public static void main(String[] args) {
		int positionCount = CompanyRepository.getAllCompanies()
		.stream()
		.filter(p1.and(p2))
		.map(Company::getPositionRanking)
		.reduce(0, Integer::sum);
		//.reduce(0, (x,y) -> (x+y));
		log.info("Number of Position :"+positionCount);
	}

}
