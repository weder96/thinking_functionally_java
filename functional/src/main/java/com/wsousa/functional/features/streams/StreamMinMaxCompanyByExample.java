package com.wsousa.functional.features.streams;

import com.wsousa.functional.features.repo.Company;
import com.wsousa.functional.features.repo.CompanyRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;
@Slf4j
public class StreamMinMaxCompanyByExample {
	static Optional<Company> getTallestCompany() {
		return CompanyRepository.getAllCompanies()
		.stream()
		.collect(Collectors.maxBy(Comparator.comparing(Company::getQtyEmployee)));
	}
	static Optional<Company> getShortestCompany() {
		return CompanyRepository.getAllCompanies()
		.stream()
		.collect(Collectors.minBy(Comparator.comparing(Company::getQtyEmployee)));
	}
	public static void main(String[] args) {
		log.info("Tallest Company : {}",getTallestCompany().get());
		log.info("Shortest Company : {}",getShortestCompany().get());
	}
}
