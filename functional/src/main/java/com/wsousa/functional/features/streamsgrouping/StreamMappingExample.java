package com.wsousa.functional.features.streamsgrouping;

import com.wsousa.functional.features.repo.Company;
import com.wsousa.functional.features.repo.CompanyRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.mapping;

public class StreamMappingExample {
	
	static List<String> mappingName(){
		List<String> names = CompanyRepository.getAllCompanies()
		.stream()
		.map(Company:: getName).
		collect(Collectors.toList());
		
		List<String> names1 = CompanyRepository.getAllCompanies()
		.stream().collect(mapping(Company::getName,Collectors.toList()));
		return names1;
	}
	
	static Set<String> mappingName1(){
		List<String> names = CompanyRepository.getAllCompanies()
		.stream()
		.map(Company :: getName).
		collect(Collectors.toList());
		
		Set<String> names1 = CompanyRepository.getAllCompanies()
		.stream().collect(mapping(Company::getName,Collectors.toSet()));
		return names1;
	}
	
	static long countTallCompanys() {
		return CompanyRepository.getAllCompanies()
				.stream()
				.filter(per -> per.getQtyEmployee() >= 140)
				.collect(Collectors.counting());
	}
	

	public static void main(String[] args) {
		//mappingName().forEach(System.out::println);
		//mappingName1().forEach(System.out::println);
		System.out.println("Total Company count :"+countTallCompanys());
	}

}
