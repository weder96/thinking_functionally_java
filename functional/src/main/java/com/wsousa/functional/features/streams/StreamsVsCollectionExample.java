package com.wsousa.functional.features.streams;

import com.wsousa.functional.features.repo.Company;
import com.wsousa.functional.features.repo.CompanyRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Slf4j
public class StreamsVsCollectionExample {

	public static void main(String[] args) {
		List<String> names = new ArrayList<String>();
		names.add("John");
		names.add("Adan");
		names.add("Nancy");
		
		for(String name : names) {
			log.info("Iteration 1 : {} ",name);
		}
		
		for(String name : names) {
			log.info("Iteration 2 : {}",name);
		}
		
		Stream<String> stream = names.stream();
		stream.forEach(p -> log.info("<<<< : {} ", p));
		
		List<String> CompanyNames = CompanyRepository
				.getAllCompanies()
				.stream()
				.peek(per -> log.info(" peek 1: {} ", per))
				.map(Company::getName)
				.peek(per -> log.info(" peek 2: {} ", per))
				.collect(Collectors.toList());


		CompanyNames.forEach(name -> log.info(">>>> : {} ", name));
	}

}
