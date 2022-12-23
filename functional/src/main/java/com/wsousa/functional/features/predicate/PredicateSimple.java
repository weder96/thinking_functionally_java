package com.wsousa.functional.features.predicate;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Predicate;

@Slf4j
public class PredicateSimple {

    public static void main(String[] args) {
        Integer num1=23;
        Integer num2=5;
        Integer value=20;
        
        Predicate<Integer> pred1 = x -> x > value;
        
        if (pred1.test(num1))
            log.info("Predicate x > {} is true for x=={}.", value, num1);
        else
            log.info("Predicate x > {} is false for x=={}.", value, num1);

        if (pred1.test(num2))
            log.info("Predicate x > {} is true for x=={}.", value, num2);
        else
            log.info("Predicate x > {} is false for x=={}.", value, num2);
    }
}
