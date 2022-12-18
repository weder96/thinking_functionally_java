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
		
		Predicate<Company> p1 = (per) -> per.getQtyEmployee() >=140 ;
		Predicate<Company> p2 = (per) -> per.getName().equals("Male");
		
		Map<String,List<String>> CompanyMap = CompanyRepository
				.getAllCompanies() // iterate all Companys
				.stream() // Stream of Companys
				.filter(p1) // Stream of Companys 
				.filter(p2) // Stream of Companys 
				.collect(Collectors
						.toMap(Company :: getName, Company :: getDepartament));
		log.info("Company Map :"+CompanyMap);
		
		List<String> companyDepartaments = CompanyRepository
				.getAllCompanies() // List of Companys
				.stream() // Stream of Companys
				.map(Company :: getDepartament) // Stream<List<String>>
				.flatMap(List::stream) // Stream<String>
				.distinct()
				.collect(Collectors.toList());// collection to be returned
		
		log.info("Company Hobbies List :"+companyDepartaments);
	}

}
