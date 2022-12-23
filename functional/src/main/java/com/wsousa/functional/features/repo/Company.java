package com.wsousa.functional.features.repo;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Company {
	private String name;
	private LocalDate creationDate;
	private int qtyEmployee;
	private BigDecimal marketValue;
	private int positionRanking;
	private boolean branch;
	private String location;
	private String ceo;
	List<String> departament = new ArrayList<>();
	Optional<Address> address;

	public Company(String name, LocalDate creationDate, int qtyEmployee, BigDecimal marketValue, int positionRanking, boolean branch, String location,String ceo, List<String> departament) {
		this.name = name;
		this.creationDate = creationDate;
		this.qtyEmployee = qtyEmployee;
		this.marketValue = marketValue;
		this.positionRanking = positionRanking;
		this.branch = branch;
		this.location = location;
		this.ceo = ceo;
		this.departament = departament;
	}
}
