package com.wsousa.functional.features.streams;

import com.wsousa.functional.features.repo.Company;
import com.wsousa.functional.features.repo.CompanyRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
@Slf4j
public class StreamReduceCompanyExample1 {

	public static void main(String[] args) {
		combineNames();
		Optional<Company> tallestCompany = getTallestCompany();
		log.info("Tallest Company is : {} ", tallestCompany.get());
	}

	private static void combineNames() {
		String names = CompanyRepository.getAllCompanies()
		.stream()
		.map(Company::getName)
		.reduce("", (a,b) -> a.concat(b).concat(" - "));
		log.info("Names are : {}", names);
	}
	
	static Optional<Company> getTallestCompany() {
		return CompanyRepository.getAllCompanies()
		.stream()
		.reduce((x,y) -> x.getQtyEmployee() > y.getQtyEmployee() ? x : y);
	}

}
