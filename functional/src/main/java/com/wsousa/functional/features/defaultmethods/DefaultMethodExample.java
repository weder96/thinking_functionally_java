package com.wsousa.functional.features.defaultmethods;

import com.wsousa.functional.features.repo.Company;
import com.wsousa.functional.features.repo.CompanyRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
@Slf4j
public class DefaultMethodExample {

	public static void main(String[] args) {
		List<String> names = CompanyRepository.getAllCompanies()
				.stream().map(Company:: getName).collect(Collectors.toList());
		names.forEach(name -> log.info(" {}",name));
		log.info("Before Sort ==============");

		Collections.sort(names);
		names.forEach(name -> log.info(" {}",name));
		log.info("After Sort ==============");

		names.sort(Comparator.naturalOrder());
		names.forEach(name -> log.info(" {}",name));
		log.info("Natural Order ==============");

		names.sort(Comparator.reverseOrder());
		names.forEach(name -> log.info(" {}",name));
		log.info("Reverse Order ==============");
	}

}
