package com.wsousa.functional.features.predicate;

import com.wsousa.functional.features.repo.Company;
import com.wsousa.functional.features.repo.CompanyRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Slf4j
public class PredicateFilterAndCompany {

	static Predicate<Company> predQtyEmployee = per -> per.getQtyEmployee() >= 140000;
	static Predicate<Company> predPositionRanking = per -> per.getPositionRanking() <= 2;

	public static void main(String[] args) {
		List<Company> companies = CompanyRepository.getAllCompanies();
		companies.forEach(company -> {
			if(predQtyEmployee.and(predPositionRanking).test(company))
				log.info("filter(F3) Stream {}", company);
		});
	}
}
