package com.solvd.other.lambda.interfaces;

@FunctionalInterface
public interface Computable<T> {
    T compute(T a, T b);
}
