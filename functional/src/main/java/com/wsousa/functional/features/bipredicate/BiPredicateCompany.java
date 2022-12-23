package com.wsousa.functional.features.bipredicate;

import com.wsousa.functional.features.repo.Company;
import com.wsousa.functional.features.repo.CompanyRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Slf4j
public class BiPredicateCompany {
	static BiPredicate<Company, Company> biPredQtyEmployeePositionRanking  = (comp1, comp2) -> comp1.getQtyEmployee() >= 140000 && comp2.getPositionRanking() <= 2;
	public static void main(String[] args) {
		CompanyRepository.getAllCompanies()
				.stream()
				.filter(company -> biPredQtyEmployeePositionRanking.test(company, company))
				.forEach(company -> log.info("filter(BiPredicate) {}", company));
	}
}
