package com.wsousa.functional.features.repo;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	String block;
	String city;
	String state;
	String country;
	int pinCode;
}
