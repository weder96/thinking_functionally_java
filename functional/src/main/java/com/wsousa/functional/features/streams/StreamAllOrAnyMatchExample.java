package com.wsousa.functional.features.streams;

import com.wsousa.functional.features.repo.Company;
import com.wsousa.functional.features.repo.CompanyRepository;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StreamAllOrAnyMatchExample {
	
	static Predicate<String> p1 = num -> num.length() > 7;
	static Predicate<Company> p2 = per -> per.getQtyEmployee() >=140;
	static Predicate<Company> p3 = per -> per.getName().equals("Male");

	public static void main(String[] args) {
		List<String> fruits = Arrays.asList("Apple","Orange","Graphs","Banana","Pineapple");
		System.out.println("Length Check All Match:"+fruits.stream().allMatch(p1));
		System.out.println("Length Check Any Match:"+fruits.stream().anyMatch(p1));
		System.out.println("Company All Match :" + CompanyRepository.getAllCompanies()
		.stream()
		.allMatch(p2));
		
		System.out.println("Company Any Match :" +CompanyRepository.getAllCompanies()
		.stream()
		.anyMatch(p2.and(p3)));
	}

}
