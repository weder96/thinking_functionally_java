package com.wsousa.functional.features.repo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class CompanyRepository {
	public static List<Company> getAllCompanies() {
		Company c1 = new Company("Apple", LocalDate.of(1976,4,1),92600, new BigDecimal(2200000000000.00), 1, false,"USA", "Timothy Donald Cook - Alabama, USA" ,Arrays.asList("Streaming", "Personal Computer", "Smartphones", "System Operational Mac", "System Operational IOS"), Optional.of(new Address(null,null, "Califórnia", "USA", 0)));
		Company c2 = new Company("Microsoft",LocalDate.of(1975,4,4),166000,  new BigDecimal(1865000000000.00), 2,false , "USA","Satya Nadella - Haiderabade, IND",Arrays.asList("System Operational Windows", "Cloud Computing", "Social Network Linkedin"), Optional.of(new Address(null, null, "Washington", "USA", 0)));
		Company c3 = new Company("Amazon", LocalDate.of(1994,7,5), 613000,  new BigDecimal(1591000000000.00), 3, false, "USA","Andrew R. Jassy -  New York, USA",Arrays.asList("Cloud Computing", "e-commerce", "Invest Startups"), Optional.of(new Address(null,null, "Washington", "USA", 0)));
		Company c4 = new Company("Alphabet Inc", LocalDate.of(1998,9,4), 85050,  new BigDecimal(1505000000000.00), 4, false, "USA","Sundar Pichai - Tamil Nadu, IND",Arrays.asList("Search Web Google", "System Operational Android", "Cloud Computing"), Optional.of(new Address(null,null, "Califórnia", "USA", 0)));
		Company c5 = new Company("Facebook",LocalDate.of(2004,4,2), 48000,  new BigDecimal(852000000000.00), 5, false, "USA","Mark Elliot Zuckerberg - New York, USA",Arrays.asList("Social Network Facebook", "Social Network Instagram", "Social Network WhatsApp"), Optional.of(new Address(null,null, "Califórnia", "USA", 0)));
		Company c6 = new Company("Tencent", LocalDate.of(1998,11,11), 54309,  new BigDecimal(731000000000.00), 6, false,"CHI", "Ma Huateng - Guangdon, CHI",Arrays.asList("Games League of Legends", "Games Fortnite", "Network Chineses", "Web Services","Smartphones"), Optional.of(new Address(null,null, "Cantão", "CHI", 0)));
		Company c7 = new Company("Alibaba",LocalDate.of(1999,6,28), 34985,  new BigDecimal(636000000000.00), 7, false, "CHI","Daniel Zhang - Xangai, CHI",Arrays.asList("e-commerce", "digital midia"), Optional.of(new Address(null,null, "Hangzhou", "CHI", 0)));
		return Arrays.asList(c1, c2, c3, c4, c5, c6, c7);
	}

	public static Company getCompany() {
		return new Company("Samsung", LocalDate.of(1969,1,13), 17400,  new BigDecimal(636000000000.00), 9, false, "KOR", "Lee Jae-yong - Seul - KOR", Arrays.asList("Eletronic", "Personal Computer", "Smartphones"));
	}
	
	public static Optional<Company> getCompanyOptional() {
		Company comp = getCompany();
		comp.setAddress(Optional.of(new Address("1600 Amphitheatre Pkwy", "Mountain View", "California", "USA", 94043)));
		return Optional.of(comp);
	}
}

/**
 * Apple - 	 Optional.of(new Address(null,null, "Califórnia", "USA", 0))
 * MIcrosoft -  Optional.of(new Address(null,null, "Washington", "USA", 0))
 * Amazon -     Optional.of(new Address(null,null, "Washington", "USA", 0))
 * Alphabet - 	Optional.of(new Address(null,null, "Califórnia", "USA", 0))
 * Facebook -  Optional.of(new Address(null,null, "Califórnia", "USA", 0))
 * Tencent -  Optional.of(new Address(null,null, "Cantão", "CHI", " 0))
 * Alibaba - Optional.of(new Address(null,null, "Hangzhou", "CHI", 0))
 * Samsung - Optional.of(new Address(null,null, "Suwon", "KOR", 0))
 * */
