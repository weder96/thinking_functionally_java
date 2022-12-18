package com.wsousa.functional.features.methodref;

import com.wsousa.functional.features.repo.Company;
import com.wsousa.functional.features.repo.CompanyRepository;

import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class MethodReferenceCompanyExample1 {
	static Function<String, String> f1 = name -> name.toUpperCase(); 
	static Function<String, String> f2 = String::toUpperCase;
	
	static Predicate<Company> p1 = per -> per.getQtyEmployee() >=100000;
	static Predicate<Company> p2 = MethodReferenceCompanyExample1:: qtyEmployeeCheck;
	static BiPredicate<Company,Integer> p3 = MethodReferenceCompanyExample1::qtyEmployeeCheckWithParam;
	static Function<String,String> f3 = MethodReferenceCompanyExample1::sayMyNameCompany ;

	public static void main(String[] args) {
		System.out.println("Lambda Expression Result :"+f1.apply("java 11"));
		System.out.println("Method Reference Result :"+f2.apply("java 11"));
		System.out.println("Predicate 1 Result :"+p1.test(CompanyRepository.getCompany()));
		System.out.println("Predicate 2 Result :"+p2.test(CompanyRepository.getCompany()));
		System.out.println("Predicate 3 Result :"+p3.test(CompanyRepository.getCompany(),950000));
		System.out.println("Function Test :"+f3.apply("java 11"));
	}
	static boolean qtyEmployeeCheck(Company per) { return per.getQtyEmployee() >= 100000; }
	static boolean qtyEmployeeCheckWithParam(Company per, Integer qtyEmployee) {
		return per.getQtyEmployee() >= qtyEmployee;
	}
	static String sayMyNameCompany(String name){
		return "Company: "+name;
	}
}
