package com.wsousa.functional.features.streams;

import com.wsousa.functional.features.repo.Company;
import com.wsousa.functional.features.repo.CompanyRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Slf4j
public class StreamFilterCompanyExample {
	
	static Predicate<Company> p1 = per -> per.getQtyEmployee() >= 100000;
	static Predicate<Company> p2 = per -> per.getPositionRanking() > 3;

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Sam","Anderson","Peter","Nancy");
		Stream<String> allNames = names.stream();
		Stream<String> updatesList = allNames.filter(s -> s.length() > 3);
		updatesList.forEach(name -> log.info("{}", name));
		names.stream().filter(s-> s.length()>3).collect(Collectors.toList()).forEach(name -> log.info("{}", name));
		
		CompanyRepository.getAllCompanies()
		.stream()
		.filter(p1.and(p2))
		//.filter(p2)
		.collect(Collectors.toList()).forEach(company -> log.info("{}", company));
		
		List<Company> l1 = CompanyRepository.getAllCompanies()
				.stream()
				.filter(per -> per.getQtyEmployee() >= 100000)
				.collect(Collectors.toList());
		l1.forEach(company -> log.info("{}", company));
		
		
	}

}
