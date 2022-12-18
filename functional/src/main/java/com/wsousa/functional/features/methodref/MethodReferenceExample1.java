package com.wsousa.functional.features.methodref;

import com.wsousa.functional.features.repo.Company;
import com.wsousa.functional.features.repo.CompanyRepository;

import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class MethodReferenceExample1 {
	
	static Function<String, String> f1 = name -> name.toUpperCase(); 
	static Function<String, String> f2 = String :: toUpperCase;
	
	static Predicate<Company> p1 = per -> per.getQtyEmployee() >=1400000;
	static Predicate<Company> p2 = MethodReferenceExample1 :: heightQtyEmployee;
	static BiPredicate<Company,Integer> p3 = MethodReferenceExample1 :: heightCheckWithParam;
	static Function<String,String> f3 = MethodReferenceExample1 :: sayMyName ;

	public static void main(String[] args) {
		//System.out.println("Lambda Expression Result :"+f1.apply("java8"));
		//System.out.println("Method Reference Result :"+f2.apply("java8"));
		System.out.println("Predicate 1 Result :"+p1.test(CompanyRepository.getCompany()));
		System.out.println("Predicate 2 Result :"+p2.test(CompanyRepository.getCompany()));
		System.out.println("Predicate 3 Result :"+p3.test(CompanyRepository.getCompany(),145));
		System.out.println("Function Test :"+f3.apply("java8"));
	}
	
	static boolean heightQtyEmployee(Company company) {
		return company.getQtyEmployee() >= 140000;
	}
	
	static boolean heightCheckWithParam(Company company, Integer qty) {
		return company.getQtyEmployee() >= qty;
	}
	
	static String sayMyName(String name){
		return "Hello Mr."+name;
	}

}
