package com.wsousa.functional.features.streams;

import com.wsousa.functional.features.repo.Company;
import com.wsousa.functional.features.repo.CompanyRepository;

import java.util.Comparator;

public class StreamCustomSortExample {

	public static void main(String[] args) {
		System.out.println("Sort By Name");
		CompanyRepository.getAllCompanies().stream()
		.sorted(Comparator.comparing(Company:: getName))
		.forEach(System.out::println);
		
		System.out.println("Sort By Height");
		CompanyRepository.getAllCompanies().stream()
		.sorted(Comparator.comparing(Company :: getQtyEmployee))
		.forEach(System.out::println); 
		
		System.out.println("Reverse Sort By Name");
		CompanyRepository.getAllCompanies().stream()
		.sorted(Comparator.comparing(Company :: getName).reversed())
		.forEach(System.out::println);
	}

}
