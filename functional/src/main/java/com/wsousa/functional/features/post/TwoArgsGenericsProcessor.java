package com.wsousa.functional.features.post;
@FunctionalInterface
public interface TwoArgsGenericsProcessor<N> {
        N process(N arg1, N arg2);
}
