package com.wsousa.functional.features.example;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
@Slf4j
public class ExecuteList {
    public static void main(String[] args) {
        final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

        log.info("for With Variable");
        for(int i = 0; i < friends.size(); i++) {
            log.info(friends.get(i));
        }

        log.info("for With Object Create");
        for(String name : friends) {
            log.info(name);
        }

        log.info("forEach With Consumer");
        friends.forEach(new Consumer<String>() {
            public void accept(final String name) {
                log.info(name);
            }
        });

        log.info("ForEach With Lambda final String");
        friends.forEach((final String name) -> log.info(name));

        log.info("ForEach With Lambda");
        friends.forEach((name) -> log.info(name));

        log.info("ForEach With Lambda 2");
        friends.forEach(name -> log.info(name));

        log.info("ForEach With Lambda ");
        friends.forEach(friend -> log.info(" {} ", friend));
    }
}
