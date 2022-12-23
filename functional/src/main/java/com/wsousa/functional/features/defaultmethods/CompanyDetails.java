package com.wsousa.functional.features.defaultmethods;

import com.wsousa.functional.features.repo.Company;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public interface CompanyDetails {
	BigDecimal calculateTotalSalary(List<Company> companies);
	
	default int totalEmployees(List<Company> companies) {
		return companies.stream().map(Company::getQtyEmployee).reduce(0, (x,y)-> x+y);
	}
	
	static List<String> companyNames(List<Company> companies){
		return companies.stream().map(Company :: getName).collect(Collectors.toList());
	}
}
