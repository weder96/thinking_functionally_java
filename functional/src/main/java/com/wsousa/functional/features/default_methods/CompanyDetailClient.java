package com.wsousa.functional.features.default_methods;

import com.wsousa.functional.features.repo.Company;
import com.wsousa.functional.features.repo.CompanyRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
@Slf4j
public class CompanyDetailClient {
	static List<Company> companies = CompanyRepository.getAllCompanies();

	public static void main(String[] args) {
		CompanyDetails pd = new CompanyDetailImpl();
		log.info("Total Salary :" + pd.calculateTotalSalary(companies));
		log.info("Total Employee Count :" + pd.totalEmployees(companies));
		CompanyDetails.companyNames(companies).forEach(company -> log.info("{}", company));
		CompanyDetailImpl.companyNames(companies).forEach(company -> log.info("{}", company));
	}

}
