package com.wsousa.functional.features.post;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyExecuteTestLambda {
    public static void main(String[] args) {
        ProcessorLamba lambdaAdd = x -> log.info("execute:  {}", x);
        lambdaAdd.methodOne(5);
    }
}
