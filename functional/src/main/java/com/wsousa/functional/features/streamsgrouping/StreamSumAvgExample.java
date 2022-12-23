package com.wsousa.functional.features.streamsgrouping;

import com.wsousa.functional.features.repo.Company;
import com.wsousa.functional.features.repo.CompanyRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamSumAvgExample {
	
	static int sumTotalKids() {
		return CompanyRepository.getAllCompanies()
				.stream()
				.collect(Collectors.summingInt(Company::getQtyEmployee));
	}
	
	static double averageHeight() {
		return CompanyRepository.getAllCompanies()
				.stream()
				.collect(Collectors.averagingInt(Company :: getPositionRanking));
	}

	public static void main(String[] args) {
		System.out.println("Total Kids :"+sumTotalKids());
		System.out.println("Average Height is:"+averageHeight());
		List<Integer> intList = Arrays.asList(1,2,3,4,5,6);
		int total = intList.stream().collect(Collectors.summingInt(Integer :: intValue));
		System.out.println("Total :"+total);
	}

}
