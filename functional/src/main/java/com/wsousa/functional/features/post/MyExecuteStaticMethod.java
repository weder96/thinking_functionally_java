package com.wsousa.functional.features.post;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyExecuteStaticMethod {
    public static void main(String[] args) {
        IntegerProcessor toAdd = new IntegerProcessor() {
            @Override
            public Integer process(Integer x) {
                return x + x;
            }
        };
        log.info(" {}", toAdd.process(20));

        IntegerProcessor toMult = new IntegerProcessor() {
            @Override
            public Integer process(Integer y)
            {
                return y * y;
            }
        };
        log.info(" {}", toMult.process(20));

        log.info(" {}", IntegerProcessor.add(40));
        log.info(" {}", IntegerProcessor.mult(50));
    }

}
