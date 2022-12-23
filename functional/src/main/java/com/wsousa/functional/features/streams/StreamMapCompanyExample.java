package com.wsousa.functional.features.streams;

import com.wsousa.functional.features.repo.Company;
import com.wsousa.functional.features.repo.CompanyRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Slf4j
public class StreamMapCompanyExample {
	static List<String> toUpperTransform(List<Company> listOfCompanies){
		return listOfCompanies.stream()
				.map(Company:: getName)
				.map(String :: toUpperCase)
				.collect(Collectors.toList());
	}

	static Set<String> toUpperTransformSet(List<Company> listOfCompanies){
		return listOfCompanies.stream()
				.map(Company::getName)
				.map(String::toUpperCase)
				.collect(Collectors.toSet());
	}

	public static List<Integer> getLengthFruits(List<String> fruits) {
		List<Integer> fruitLength = fruits.stream()
				.map(String::length)
				.collect(Collectors.toList());
		return fruitLength;
	}

	public static void main(String[] args) {
		List<String> fruits = Arrays.asList("Apple","Orange","Banana","Pineapple");
		List<Integer> fruitLength = getLengthFruits(fruits);
		log.info("Length List : {} ",fruitLength);
		log.info("To Uppercase List Result : {}",toUpperTransform(CompanyRepository.getAllCompanies()));
		log.info("To Uppercase Set Result : {}",toUpperTransformSet(CompanyRepository.getAllCompanies()));
	}

}
