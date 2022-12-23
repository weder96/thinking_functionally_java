package com.wsousa.functional.features.predicate;

import lombok.extern.slf4j.Slf4j;

import java.util.function.IntPredicate;
@Slf4j
public class PredicateArgMethods {
    public static void checkPredicate(IntPredicate pred, Integer num) {
        if (pred.test(num))
            log.info("The Predicate is true for {} " , num);
        else
            log.info("The Predicate is false for " + num);
    }
    public static void main(String[] args) {
        IntPredicate pred1 = x -> x == 5;
        checkPredicate(pred1,5);
        checkPredicate(y -> y%2 == 0, 5);
    }
}
