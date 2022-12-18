package com.wsousa.functional.features.streams;

import com.wsousa.functional.features.repo.Company;
import com.wsousa.functional.features.repo.CompanyRepository;

import java.util.Optional;
import java.util.function.Predicate;

public class StreamFindAnyFirstExample {
	static Predicate<String> p1 = num -> num.length() > 7;
	static Predicate<Company> p2 = per -> per.getQtyEmployee() >= 200;
	static Predicate<Company> p3 = per -> per.getName().equals("Male");

	public static void main(String[] args) {
		Optional<Company> findAny = findAny();
		if(findAny.isPresent())
			System.out.println("Find Any Result :"+findAny.get());
		else
			System.out.println("No Record Found");
		Optional<Company> findFirst = findFirst();
		if(findFirst.isPresent())
			System.out.println("Find First Result :"+findFirst().get());
		else
			System.out.println("No Record Found");
	}
	
	static Optional<Company> findAny() {
		return CompanyRepository.getAllCompanies()
		.stream()
		.filter(p2)
		.findAny();		
	}
	
	static Optional<Company> findFirst() {
		return CompanyRepository.getAllCompanies()
		.stream()
		.filter(p3)
		.findAny();		
	}

}
