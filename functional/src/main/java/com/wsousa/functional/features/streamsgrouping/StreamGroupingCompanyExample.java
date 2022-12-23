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

public class StreamGroupingCompanyExample {
	static void groupByLocation() {
		Map<String,List<Company>> groupedData = CompanyRepository.getAllCompanies().stream().collect(Collectors.groupingBy(Company :: getLocation));
		groupedData.entrySet().forEach(per -> System.out.println("Key :"+per.getKey()+"/ Value :"+per.getValue()));
		Stream.of(groupedData).forEach(System.out::println);
	}
	static void groupByQtyEmployee() {
		Map<String,List<Company>> groupedData = CompanyRepository.getAllCompanies().stream()
				.collect(Collectors.groupingBy(per -> per.getQtyEmployee() >= 100000 ? "Tallest":"Shortest"));
		Stream.of(groupedData).forEach(System.out::println);
	}
	static void twoLevelGrouping() {
		Map<String,Map<String,List<Company>>> groupedData= CompanyRepository.getAllCompanies()
		.stream()
		.collect(Collectors.groupingBy(Company::getLocation, groupingBy(per -> per.getQtyEmployee() >= 100000 ? "Tallest":"Shortest")));
		Stream.of(groupedData).forEach(System.out::println);
	}
	static void twoLevelGroupingCount() {
		Map<String , Integer> groupedData = CompanyRepository.getAllCompanies()
		.stream()
		.collect(Collectors.groupingBy(Company :: getName, summingInt(Company :: getQtyEmployee)));
		Stream.of(groupedData).forEach(System.out::println);
	}
	static void threeLevelGrouping() {
		Map<String,List<Company>> groupedData = CompanyRepository.getAllCompanies()
				.stream()
				.collect(Collectors.groupingBy(Company::getName, HashMap::new , Collectors.toList()));
		Stream.of(groupedData).forEach(System.out::println);
	}

	public static void main(String[] args) {
		// groupByLocation();
		// groupByQtyEmployee();
		 twoLevelGrouping();
		 twoLevelGroupingCount();
		 threeLevelGrouping();
	}

}
