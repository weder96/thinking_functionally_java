package com.wsousa.functional.features.streams;

import com.wsousa.functional.features.repo.Company;
import com.wsousa.functional.features.repo.CompanyRepository;

import java.util.function.Predicate;

public class StreamMapFilterReduceExample {
	
	static Predicate<Company> p1 = (per) -> per.getQtyEmployee() >=140 ;
	static Predicate<Company> p2 = (per) -> per.getName().equals("Male");

	public static void main(String[] args) {
		int kidsCount = CompanyRepository.getAllCompanies()
		.stream()
		.filter(p1.and(p2))
		.map(Company :: getPositionRanking)
		//.reduce(0,Integer :: sum);
		.reduce(0, (x,y) -> (x+y));
		System.out.println("Number of Kids :"+kidsCount);
	}

}
