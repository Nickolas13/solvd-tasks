package com.solvd.lambda.interfaces;

import com.solvd.other.lambda.interfaces.Computable;
import org.junit.jupiter.api.Test;

class ComputableTest {

    @Test
    public void TestComputation() {
        Computable<Integer> sum = (a, b) -> a + b;
        System.out.println(sum.compute(4, 7));
        Computable<Integer> division = (a, b) -> a / b;
        System.out.println(division.compute(8, 6));
        Computable<Integer> multiply = (a, b) -> a * b;
        System.out.println(multiply.compute(6, 6));
        Computable<Integer> subtract = (a, b) -> a - b;
        System.out.println(subtract.compute(10, 5));

        Computable<String> addStrings = (a, b) -> a + b;
        System.out.println(addStrings);
    }


}