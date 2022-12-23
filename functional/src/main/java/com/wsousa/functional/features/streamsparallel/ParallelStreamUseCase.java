package com.wsousa.functional.features.streamsparallel;

import com.wsousa.functional.features.repo.Company;
import com.wsousa.functional.features.repo.CompanyRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ParallelStreamUseCase {

	public static void main(String[] args) {
		System.out.println(getHobbiesBySeq());
		System.out.println(getHobbiesByParallel());
	}
	
	static List<String> getHobbiesBySeq(){
		long start = System.currentTimeMillis();
		List<String> hobbies = CompanyRepository.getAllCompanies()
				.stream()
				.map(Company:: getDepartament)
				.flatMap(List :: stream)
				.collect(Collectors.toList());
		long end = System.currentTimeMillis();
		System.out.println("Sequential Duration :"+(end-start));
		return hobbies;
	} 
	
	static List<String> getHobbiesByParallel(){
		long start = System.currentTimeMillis();
		List<String> hobbies = CompanyRepository.getAllCompanies()
				.parallelStream()
				.map(Company:: getDepartament)
				.flatMap(List :: stream)
				.collect(Collectors.toList());
		long end = System.currentTimeMillis();
		System.out.println("Parallel Duration :"+(end-start));
		return hobbies;
	} 

}
