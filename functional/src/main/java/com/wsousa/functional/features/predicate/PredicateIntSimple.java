package com.wsousa.functional.features.predicate;

import lombok.extern.slf4j.Slf4j;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

@Slf4j
public class PredicateIntSimple {

    public static void main(String[] args) {
        Integer num1=23;
        Integer num2=5;
        Integer value=20;
        
        IntPredicate pred1 = x -> x > value;
        
        if (pred1.test(num1))
            log.info("IntPredicate x > {} is true for x=={}.", value, num1);
        else
            log.info("IntPredicate x > {} is false for x=={}.", value, num1);

        if (pred1.test(num2))
            log.info("IntPredicate x > {} is true for x=={}.", value, num2);
        else
            log.info("IntPredicate x > {} is false for x=={}.", value, num2);
    }
}
