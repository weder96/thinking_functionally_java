package com.wsousa.functional.features.streams;

import com.wsousa.functional.features.repo.Company;
import com.wsousa.functional.features.repo.CompanyRepository;

import java.util.Optional;

public class StreamReduceCompanyExample {

	public static void main(String[] args) {
		combineNames();
		Optional<Company> tallestCompany = getTallestCompany();
		System.out.println("Tallest Company is :"+tallestCompany.get());
	}

	private static void combineNames() {
		String names = CompanyRepository.getAllCompanies()
		.stream()
		.map(Company :: getName)
		.reduce("", (a,b) -> a.concat(b));
		System.out.println("Names are :"+names);
	}
	
	static Optional<Company> getTallestCompany() {
		return CompanyRepository.getAllCompanies()
		.stream()
		.reduce((x,y) -> x.getQtyEmployee() > y.getQtyEmployee() ? x : y);
	}

}
