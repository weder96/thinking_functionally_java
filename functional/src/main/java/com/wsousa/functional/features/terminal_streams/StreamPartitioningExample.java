package com.wsousa.functional.features.terminal_streams;

import com.wsousa.functional.features.repo.Company;
import com.wsousa.functional.features.repo.CompanyRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.partitioningBy;

@Slf4j
public class StreamPartitioningExample {
	
	static Predicate<Company> p1 = per -> per.getQtyEmployee() >= 140;
	
	static void byHeight() {
		Map<Boolean,List<Company>> map = CompanyRepository.getAllCompanies()
		.stream()
		.collect(partitioningBy(p1));
		log.info("Company Map 1:"+map);
	}
	
	static void byHeightWith2Param() {
		Map<Boolean,Set<Company>> map =CompanyRepository.getAllCompanies()
		.stream()
		.collect(partitioningBy(p1,Collectors.toSet()));
		log.info("Company Map 2:"+map);
	}
	
	static void byHeightWithMap() {
		Map<Boolean,Map<String,List<String>>> map =CompanyRepository.getAllCompanies()
		.stream()
		.collect(partitioningBy(p1,Collectors.toMap(Company :: getName, Company ::getDepartament)));
		log.info("Company Map 3:"+map);
	}

	public static void main(String[] args) {
		//byHeight();
		//byHeightWith2Param();
		byHeightWithMap();
	}

}
