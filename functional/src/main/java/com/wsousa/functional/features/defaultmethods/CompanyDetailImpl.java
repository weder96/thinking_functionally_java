package com.wsousa.functional.features.defaultmethods;

import com.wsousa.functional.features.repo.Company;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class CompanyDetailImpl implements CompanyDetails {


	static List<String> companyNames(List<Company> companies){
		return Arrays.asList("One","Two");
	}

	@Override
	public BigDecimal calculateTotalSalary(List<Company> companies) {
		return companies.stream().map(Company::getMarketValue).reduce(BigDecimal.ZERO, (x, y)-> x.add(y));
	}

	@Override
	public int totalEmployees(List<Company> companies) {
		return CompanyDetails.super.totalEmployees(companies);
	}
}
