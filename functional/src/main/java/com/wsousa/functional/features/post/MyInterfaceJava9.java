package com.wsousa.functional.features.post;

import java.util.Random;

public interface MyInterfaceJava9 {
    private int getNumber() { return (new Random()).nextInt(100); }
    default String concatNumber(String s) { return s + getNumber();}
}
