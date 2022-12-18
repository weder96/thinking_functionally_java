package com.wsousa.functional.features.streams;

import com.wsousa.functional.features.repo.Company;
import com.wsousa.functional.features.repo.CompanyRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFlatMapExample {
	
	static List<String> departament(List<Company> CompanysList){
		return CompanysList.stream()
				.map(Company :: getDepartament)
				.flatMap(List:: stream)
				.collect(Collectors.toList());
	}
	
	static List<String> distinctDepartament(List<Company> CompanysList){
		return CompanysList.stream()
				.map(Company :: getDepartament)
				.flatMap(List :: stream)
				.sorted()
				.distinct()
				.collect(Collectors.toList());
	}
	
	static long countOfDepartament(List<Company> CompanysList) {
		return CompanysList.stream()
				.map(Company :: getDepartament)
				.flatMap(List :: stream)
				.distinct()
				.count();
	}

	public static void main(String[] args) {
		List<Integer> oddNumber = Arrays.asList(1,3,5,7);
		List<Integer> evenNumber = Arrays.asList(2,4,6,8);
		
		List<List<Integer>> listofList = Arrays.asList(oddNumber,evenNumber);
		System.out.println("Before Flatten :"+listofList);
		
		List<Integer> flattenList = listofList.stream()
				.flatMap(list -> list.stream())
				.collect(Collectors.toList());
		System.out.println("After Flatten :"+flattenList);
		
		System.out.println("Departament Result with Duplicates :"+departament(CompanyRepository.getAllCompanies()));
		System.out.println("Departament Result without Duplicates :"+distinctDepartament(CompanyRepository.getAllCompanies()));
		System.out.println("Departament Count :"+countOfDepartament(CompanyRepository.getAllCompanies()));
	}

}
