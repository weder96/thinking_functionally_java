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
public class SimpleStreamCompanyExample {

	public static void main(String[] args) {
		Predicate<Company> p1 = (per) -> per.getQtyEmployee() >=100000 ;
		Predicate<Company> p2 = (per) -> per.getPositionRanking() <= 4;

		Map<String,List<String>> CompanyMap = CompanyRepository
				.getAllCompanies() // iterate all Companys
				.stream() // Stream of Companys
				.filter(p1) // Stream of Companys
				.filter(p2) // Stream of Companys
				.collect(Collectors
						.toMap(Company::getName, Company::getDepartament));
		log.info("Company Map :"+CompanyMap);

		List<String> CompanyDepartament = CompanyRepository
				.getAllCompanies() // List of Companys
				.stream() // Stream of Companys
				.map(Company::getDepartament) // Stream<List<String>>
				.flatMap(List::stream) // Stream<String>
				.distinct()
				.collect(Collectors.toList());// collection to be returned

		log.info("Company Departament List : {}",CompanyDepartament);
	}

}
