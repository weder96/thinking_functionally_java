package com.wsousa.functional.features.biFunction;

import com.wsousa.functional.features.repo.Company;
import com.wsousa.functional.features.repo.CompanyRepository;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

@Slf4j
public class BiFunctionCompany {
	static BiFunction<String, String, String> biFunctionConcat = (a, b) -> (a+" "+b);
	static Predicate<Company> predQtdEmployee = per -> per.getQtyEmployee() >= 90000;
	static Predicate<Company> predPositionRanking = per -> per.getPositionRanking() <= 4;

	public static void main(String[] args) {
		List<Company> companies = CompanyRepository.getAllCompanies();
		Map<String,BigDecimal> map = biFunctionMap.apply(companies, predPositionRanking);
		map.forEach((key, value) -> log.info(key +" - "+ value));
	}

	static BiFunction<List<Company>, Predicate<Company>, Map<String,BigDecimal>> biFunctionMap = (listOfCompanys, predicate) -> {
		Map<String, BigDecimal> map = new HashMap<String,BigDecimal>();
		listOfCompanys.forEach(per -> {
			if(predQtdEmployee.and(predicate).test(per))
				map.put(per.getName(), per.getMarketValue());
		});
		return map;
	};
}
 