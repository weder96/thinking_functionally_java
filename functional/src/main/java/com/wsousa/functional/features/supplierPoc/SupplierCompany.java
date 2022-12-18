package com.wsousa.functional.features.supplierPoc;

import com.wsousa.functional.features.repo.Company;
import com.wsousa.functional.features.repo.CompanyRepository;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Supplier;
@Slf4j
public class SupplierCompany {
	
	static Supplier<Company> supplier1 = CompanyRepository::getCompany;
	static Supplier<List<Company>> supplier2 = CompanyRepository::getAllCompanies;
	static Supplier<LocalDate> supplierLocalDate = LocalDate::now;
	static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

	public static void main(String[] args) {
		log.info("Result : {}", supplier1.get());
		log.info("Result : {}", supplier2.get());

		log.info("Equals : {}", LocalDate.now().equals(supplierLocalDate.get()));
		Supplier<String> supplier = () -> dateTimeFormatter.format(LocalDateTime.now());
		log.info("Equals2 : {}",dateTimeFormatter.format(LocalDateTime.now()).equals(supplier.get()));
	}
}
