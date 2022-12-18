package com.wsousa.functional.features.consumer;

import com.wsousa.functional.features.repo.Company;
import com.wsousa.functional.features.repo.CompanyRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;
@Slf4j
public class ConsumerPredicateCompany {

	static Predicate<Company> predQtyEmployeee = per -> per.getQtyEmployee() >= 100000;
	static Predicate<Company> predPositionRanking = per -> per.getPositionRanking() <= 3;

	static BiPredicate<Integer, Integer> biPredQtyPositionEmployee = (qtyEmployee, positionRanking) -> qtyEmployee >= 100000
											   && positionRanking <= 3;
	static BiConsumer<String, List<String>> biConsumerDepartament = (name, departament) ->
			log.info(name + " " + departament);

	static Consumer<Company> CompanyConsumer = per -> {
		//if (p1.and(p2).test(per)) {
		if(biPredQtyPositionEmployee.test(per.getQtyEmployee(), per.getPositionRanking())) {
			biConsumerDepartament.accept(per.getName(), per.getDepartament());
		}
	};
	public static void main(String[] args) {
		List<Company> Companies = CompanyRepository.getAllCompanies();
		// p1.accept(Companies);
		// p2.accept(CompanyRepository.getAllCompanies());
		// p3.accept(CompanyRepository.getAllCompanies());
		// p1.andThen(p2).andThen(p3).accept(CompanyRepository.getAllCompanies());
		Companies.forEach(CompanyConsumer);
	}
}
