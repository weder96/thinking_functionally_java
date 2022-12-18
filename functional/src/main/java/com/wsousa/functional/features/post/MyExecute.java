package com.wsousa.functional.features.post;

public class MyExecute {
    public static void main(String[] args)
    {
        MyInterface.method1();
        MyInterface objC = new MyClass();
        MyInterface objC2 = new MyClass2();
        System.out.println(objC.method2("Hello"));
        System.out.println(objC2.method2("World"));
    }
}
