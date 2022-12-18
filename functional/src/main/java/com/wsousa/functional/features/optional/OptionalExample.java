package com.wsousa.functional.features.optional;

import com.wsousa.functional.features.repo.Company;
import com.wsousa.functional.features.repo.CompanyRepository;

import java.util.Optional;

public class OptionalExample {
	public static void main(String[] args) {
		System.out.println("Result :"+myName("John"));
		Optional<String> name = Optional.ofNullable(myName("John"));
		String name1 = Optional.ofNullable(myName("John")).get();
		System.out.println(name.isPresent() ? name.get():"No Data Found");
		System.out.println("Company Name :"+CompanyName(new Company()));
		Optional<String> Companyname = CompanyNameWithOptional(CompanyRepository.getCompanyOptional());
		System.out.println("The Optional Company Name is :"+Companyname.get());
	}
	
	static String myName(String name) {
		return name;		
	}
	static String CompanyName(Company per) {  return per!=null ? per.getName() : "No Data Found"; }
	static Optional<String> CompanyNameWithOptional(Optional<Company> per){
		return  (per.isPresent()) ?  per.map(Company :: getName) : Optional.empty();
	}
}
