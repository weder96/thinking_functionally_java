package com.wsousa.functional.features.post;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TwoArgsGenericsProcessorTest {
    public static void main(String[] args) {
        TwoArgsGenericsProcessor<Integer> multiplyInts = new TwoArgsGenericsProcessor<>() {
            @Override
            public Integer process(Integer arg1, Integer arg2) {
                return arg1 * arg2;
            }
        };
        log.info(" {}", multiplyInts.process(12, 20));
    }
}
