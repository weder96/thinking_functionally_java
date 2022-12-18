package com.wsousa.functional.features.example;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@Slf4j
public class ExecuteStartWithN {
    public static void main(String[] args) {
        final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

        final List<String> startsWithN = new ArrayList<String>();
        for(String name : friends) {
            if(name.startsWith("N")) {
                startsWithN.add(name);
            }
        }

        startsWithN.forEach(friend -> log.info("{}",friend));
        log.info("");

        final List<String> startsWithNStream = friends.stream()
                        .filter(name -> name.startsWith("N"))
                        .collect(Collectors.toList());

        startsWithNStream.forEach(friend -> log.info("{}",friend));
        log.info(String.format("Found %d names", startsWithNStream.size()));



    }
}
