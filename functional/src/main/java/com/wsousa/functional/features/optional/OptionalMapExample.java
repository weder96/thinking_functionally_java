package com.wsousa.functional.features.optional;

import com.wsousa.functional.features.repo.Address;
import com.wsousa.functional.features.repo.Company;
import com.wsousa.functional.features.repo.CompanyRepository;

import java.util.Optional;

public class OptionalMapExample {
	public static void main(String[] args) {
		optionalMapExample();
		optionalFlatMapExample();
		optionalMapFilterExample();
	}
	static void optionalMapExample() {
		Optional<Company> per = CompanyRepository.getCompanyOptional();
		per.ifPresent(Company -> {
			String name = per.map(company -> company.getName()).orElse("No Data Found");
			System.out.println("Name :"+name);
		} );
	}
	static void optionalFlatMapExample() {
		Optional<Company> per = CompanyRepository.getCompanyOptional();
		if(per.isPresent()) {
			Optional<Address> add = per.flatMap(Company :: getAddress);
			System.out.println("Address :"+add.get());
		}
	}
	static void optionalMapFilterExample() {
		Optional<Company> per = CompanyRepository.getCompanyOptional().filter(Company -> Company.getQtyEmployee() >=140000);
		per.ifPresent(Company -> System.out.println(Company.getAddress().get()));
	}
}
