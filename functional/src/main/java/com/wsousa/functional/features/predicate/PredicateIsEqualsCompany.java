package com.wsousa.functional.features.predicate;

import com.wsousa.functional.features.repo.Company;
import com.wsousa.functional.features.repo.CompanyRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Predicate;

@Slf4j
public class PredicateIsEqualsCompany {

	public static void main(String[] args) {

		Predicate<List<Company>> companyChina = company -> {
			for (Company comp: company) {
				if (comp.getLocation().equals("CHI")) {
					return true;
				}
			}
			return false;
		};

		// companyChina.test(company -> log.info("filter location {}", company));
	}
}
