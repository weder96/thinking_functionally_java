package com.wsousa.functional.features.predicate;

import com.wsousa.functional.features.repo.Company;
import com.wsousa.functional.features.repo.CompanyRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Slf4j
public class PredicateFilterAndForEachCompany {

	static Predicate<Company> predQtyEmployee = per -> per.getQtyEmployee() >= 140000;
	static Predicate<Company> predPositionRanking = per -> per.getPositionRanking() <= 2;

	public static void main(String[] args) {
		List<Company> companies = CompanyRepository.getAllCompanies();

		List<Company> companiesFilters =
				companies.stream()
						.filter(predQtyEmployee.and(predPositionRanking)::test)
						.collect(Collectors.toList());

		companiesFilters.forEach(company -> log.info("filter(F2) Stream {}", company));
	}
}
