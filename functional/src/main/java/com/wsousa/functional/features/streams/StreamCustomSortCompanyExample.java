package com.wsousa.functional.features.streams;

import com.wsousa.functional.features.repo.Company;
import com.wsousa.functional.features.repo.CompanyRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
@Slf4j
public class StreamCustomSortCompanyExample {

	public static void main(String[] args) {
		log.info("Sort By Name");
		CompanyRepository.getAllCompanies().stream()
		.sorted(Comparator.comparing(Company::getName))
		.forEach(company->log.info("{}", company));

		log.info("");
		log.info("Sort By qtyEmployee");
		CompanyRepository.getAllCompanies().stream()
		.sorted(Comparator.comparing(Company::getQtyEmployee))
		.forEach(company->log.info("{}", company));

		log.info("");
		log.info("Reverse Sort By Name");
		CompanyRepository.getAllCompanies().stream()
		.sorted(Comparator.comparing(Company::getName).reversed())
		.forEach(company->log.info("{}", company));
	}

}
