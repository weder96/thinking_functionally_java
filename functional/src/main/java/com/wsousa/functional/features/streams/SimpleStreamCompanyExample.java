package com.wsousa.functional.features.streams;

import com.wsousa.functional.features.repo.Company;
import com.wsousa.functional.features.repo.CompanyRepository;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class SimpleStreamCompanyExample {

	public static void main(String[] args) {
		Stream<Integer> s1 = Stream.of(1,2,3,4,5,6);
		s1.forEach(p-> System.out.printf("%d ",p));
		System.out.println(" ");
		System.out.println("=============");
		Stream<Integer> s2 = Stream.of(new Integer[] {1,2,3,4,5,6,});
		s2.forEach(p-> System.out.printf("%d ",p));
		System.out.println(" ");

		Predicate<Company> p1 = (per) -> per.getQtyEmployee() >=100000 ;
		Predicate<Company> p2 = (per) -> per.getPositionRanking() <= 4;

		Map<String,List<String>> CompanyMap = CompanyRepository
				.getAllCompanies() // iterate all Companys
				.stream() // Stream of Companys
				.filter(p1) // Stream of Companys
				.filter(p2) // Stream of Companys
				.collect(Collectors
						.toMap(Company::getName, Company::getDepartament));
		System.out.println("Company Map :"+CompanyMap);

		List<String> CompanyDepartament = CompanyRepository
				.getAllCompanies() // List of Companys
				.stream() // Stream of Companys
				.map(Company::getDepartament) // Stream<List<String>>
				.flatMap(List::stream) // Stream<String>
				.distinct()
				.collect(Collectors.toList());// collection to be returned

		System.out.println("Company Departament List :"+CompanyDepartament);
	}

}
