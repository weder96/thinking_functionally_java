package com.wsousa.functional.features.default_methods;

import com.wsousa.functional.features.repo.Company;
import com.wsousa.functional.features.repo.CompanyRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
@Slf4j
public class DefaultCustomSortExample {
	
	static Comparator<Company> c1 = Comparator.comparing(Company :: getName);
	static Comparator<Company> c2 = Comparator.comparingDouble(Company :: getQtyEmployee);
	

	public static void main(String[] args) {
		List<Company> companies = CompanyRepository.getAllCompanies();
		//sortByName(listOfCompanys);
		//sortByHeight(listOfCompanys);
		//sortByHeightandName(listOfCompanys);
		//sortByNameWithNull(listOfCompanys);
		sortByNameWithNullLast(companies);
	}
	
	static void sortByName(List<Company> companies) {
		companies.sort(c1);
		companies.forEach(company -> log.info(" {}", company));
	}
	
	static void sortByHeight(List<Company> listOfCompanys) {
		listOfCompanys.sort(c2);
		listOfCompanys.forEach(company -> log.info(" {}",company));
	}
	
	static void sortByHeightandName(List<Company> listOfCompanys) {
		listOfCompanys.sort(c1.thenComparing(c2));
		listOfCompanys.forEach(company -> log.info(" {}",company));
	}
	
	static void sortByNameWithNull(List<Company> listOfCompanys) {
		Comparator<Company> nullComp = Comparator.nullsFirst(c1);
		listOfCompanys.sort(nullComp);
		listOfCompanys.forEach(company -> log.info(" {}",company));
	}
	
	static void sortByNameWithNullLast(List<Company> companies) {
		Comparator<Company> nullComp = Comparator.nullsLast(c1);
		companies.sort(nullComp);
		companies.forEach(company -> log.info(" {}",company));
	}

}
