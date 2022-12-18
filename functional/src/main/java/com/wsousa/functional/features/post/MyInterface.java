package com.wsousa.functional.features.post;

public interface MyInterface {

    String s = "myInterface ";
    static void method1() {System.out.println(s);}
    default String method2(String name) {return s + name;}
}
