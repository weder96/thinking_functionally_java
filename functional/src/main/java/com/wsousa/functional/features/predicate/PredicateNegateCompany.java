package com.wsousa.functional.features.predicate;

import com.wsousa.functional.features.repo.Company;
import com.wsousa.functional.features.repo.CompanyRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Predicate;

@Slf4j
public class PredicateNegateCompany {

	static Predicate<Company> predLocationUSA = per -> per.getLocation().contains("USA");
	public static void main(String[] args) {
		CompanyRepository.getAllCompanies()
						 .stream()
						 .filter(predLocationUSA.negate())
						 .forEach(company -> log.info("filter location {}", company));
	}
}
