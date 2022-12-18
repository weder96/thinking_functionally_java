package com.wsousa.functional.features.consumer;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;
@Slf4j
public class ConsumerPoc {

	public static void main(String[] args) {
		Consumer<String> con1 = (s) -> {log.info(s.toUpperCase());};
		con1.accept("java11");

		Consumer<String> con2 = (s) -> log.info(s.toLowerCase());
		con2.accept("java15");

		con1.andThen(con2).accept("java19");
	}

}
