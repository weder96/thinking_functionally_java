package com.wsousa.functional.features.predicate;

import lombok.extern.slf4j.Slf4j;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

@Slf4j
public class PredicateArgGenerics {
    public static <T> void checkPredicate(Predicate<T> pred, T arg) {
        if (pred.test(arg))
            log.info("The Predicate is true for {} " , arg);
        else
            log.info("The Predicate is false for " + arg);
    }
    public static void main(String[] args) {
        Predicate<Integer> pred1 = x -> x == 5;
        Predicate<String> pred2 = s -> s.startsWith("W");
        checkPredicate(pred1,5);
        checkPredicate(pred2, "Weder");
    }
}
