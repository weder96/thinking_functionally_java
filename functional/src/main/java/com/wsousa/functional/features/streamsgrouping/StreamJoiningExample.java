package com.wsousa.functional.features.streamsgrouping;

import com.wsousa.functional.features.repo.Company;
import com.wsousa.functional.features.repo.CompanyRepository;

import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamJoiningExample {
	
	static String joiningExample() {
		String s = CompanyRepository.getAllCompanies()
				.stream()
				.map(Company:: getName)
				//.collect(Collectors.joining());
				//.collect(Collectors.joining("-"));
				.collect(Collectors.joining("-","[","]"));
		return s;
	}

	public static void main(String[] args) {
		char[] ch = {'a','b','c','d','e'};
		String join = Stream.of(ch).map(arr -> new String(arr)).collect(Collectors.joining("-","[","]"));
		//System.out.println("Joined Data :"+join);
		System.out.println("Joining Output :"+joiningExample());
	}

}
