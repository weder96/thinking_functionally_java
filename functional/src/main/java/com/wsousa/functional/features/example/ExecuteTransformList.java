package com.wsousa.functional.features.example;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Slf4j
public class ExecuteTransformList {
    public static void main(String[] args) {
        final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

        final List<String> uppercaseNames = new ArrayList<String>();
        for(String name : friends) {
            uppercaseNames.add(name.toUpperCase());
        }
        uppercaseNames.forEach(name -> log.info("{}",name));
        log.info("");

        final List<String> uppercaseNames2 = new ArrayList<String>();
        friends.forEach(name -> uppercaseNames2.add(name.toUpperCase()));
        uppercaseNames2.forEach(System.out::println);
        log.info("");

        log.info("Maps");
        friends.stream()
                .map(name -> name.toUpperCase())
                .forEach(name -> log.info(name + " "));
        log.info("");

        friends.stream()
                .map(name -> name.length())
                .forEach(count -> log.info(count + " "));

        friends.stream()
                .map(String::toUpperCase)
                .forEach(name -> log.info(name));
    }
}
