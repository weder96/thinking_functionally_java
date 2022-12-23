package com.wsousa.functional.features.streamsgrouping;

import com.wsousa.functional.features.repo.Company;
import com.wsousa.functional.features.repo.CompanyRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class StreamGroupingExample {
	
	static void groupByGender() {
		Map<String,List<Company>> groupedData = CompanyRepository.getAllCompanies().stream().collect(Collectors.groupingBy(Company :: getName));
		//groupedData.entrySet().forEach(per -> System.out.println("Key :"+per.getKey()+"/ Value :"+per.getValue()));
		Stream.of(groupedData).forEach(System.out::println);
	}
	
	static void groupByHeight() {
		Map<String,List<Company>> groupedData = CompanyRepository.getAllCompanies().stream()
				.collect(Collectors.groupingBy(per -> per.getQtyEmployee() >= 14000 ? "Tallest":"Shortest"));
		Stream.of(groupedData).forEach(System.out::println);
	}
	
	static void twoLevelGrouping() {
		Map<String,Map<String,List<Company>>> groupedData= CompanyRepository.getAllCompanies()
		.stream()
		.collect(Collectors.groupingBy(Company :: getName, groupingBy(per -> per.getQtyEmployee() >= 140 ? "Tallest":"Shortest")));
		Stream.of(groupedData).forEach(System.out::println);
	}
	static void twoLevelGroupingCount() {
		Map<String , Integer> groupedData = CompanyRepository.getAllCompanies()
		.stream()
		.collect(Collectors.groupingBy(Company :: getName, summingInt(Company :: getPositionRanking)));
		Stream.of(groupedData).forEach(System.out::println);
	}
	
	static void threeLevelGrouping() {
		Map<String,List<Company>> groupedData = CompanyRepository.getAllCompanies()
				.stream()
				.collect(Collectors.groupingBy(Company::getName, HashMap :: new , Collectors.toList()));
		Stream.of(groupedData).forEach(System.out::println);
	}

	public static void main(String[] args) {
		//groupByGender();
		//groupByHeight();
		//twoLevelGrouping();
		//twoLevelGroupingCount();
		threeLevelGrouping();
	}

}
