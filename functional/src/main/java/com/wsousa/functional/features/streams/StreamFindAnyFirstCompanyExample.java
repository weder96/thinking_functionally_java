package com.wsousa.functional.features.streams;

import com.wsousa.functional.features.repo.Company;
import com.wsousa.functional.features.repo.CompanyRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import java.util.function.Predicate;
@Slf4j
public class StreamFindAnyFirstCompanyExample {
	static Predicate<Company> p2 = per -> per.getQtyEmployee() >= 100000;
	static Predicate<Company> p3 = per -> per.getPositionRanking() < 4;
	public static void main(String[] args) {
		Optional<Company> findAny = findAny();
		if(findAny.isPresent()){log.info("Find Any Result : {}",findAny.get());}
		else {log.info("No Record Found");}

		Optional<Company> findFirst = findFirst();
		if(findFirst.isPresent()) {log.info("Find First Result : {}",findFirst().get());}
		else{ log.info("No Record Found");}
	}
	static Optional<Company> findAny() {
		return CompanyRepository.getAllCompanies().stream().filter(p2).findAny();
	}
	static Optional<Company> findFirst() {
		return CompanyRepository.getAllCompanies().stream().filter(p3).findFirst();
	}
}
