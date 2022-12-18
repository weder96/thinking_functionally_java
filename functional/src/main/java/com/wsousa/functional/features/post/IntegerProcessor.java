package com.wsousa.functional.features.post;

@FunctionalInterface
public interface IntegerProcessor {
    Integer process(Integer x);
    static Integer add(Integer x) {
        return x+x;
    }
    static Integer mult(Integer x) {
        return x*x;
    }
}
