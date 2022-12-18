package com.wsousa.functional.features.optional;

import com.wsousa.functional.features.repo.Company;
import com.wsousa.functional.features.repo.CompanyRepository;

import java.util.Optional;

public class OptionalIfElseExample {

	public static void main(String[] args) {
	    orElse();
		orElseGet();
		orElseThrow();
	}
	
	static void orElse() {
		Optional<Company> Company = CompanyRepository.getCompanyOptional();
		String name = Company.isPresent() ? Company.get().getName() : "Data Not Found";
		// String name = Company.map(Company :: getName).orElse("Data Not Found");
		System.out.println("OrElse Company Name :"+name);
	}
	
	static void orElseGet() {
		Optional<Company> companyOpt = CompanyRepository.getCompanyOptional();
		String name = companyOpt.map(company -> company.getName()).orElseGet(()-> {
			// to send a notification mail // Initiate any script
			return "Data Not Found";
		});
		System.out.println("OrElseGet Company Name :"+name);
	}
	
	static void orElseThrow() {
		Optional<Company> Company = CompanyRepository.getCompanyOptional();
		String name = Company.isPresent() ? Company.get().getName() : "Data Not Found";
		// String name = Company.map(Company :: getName).orElseThrow(()-> new RuntimeException("Name Not Found"));
		System.out.println("OrElse Company Name :"+name);
	}
}
