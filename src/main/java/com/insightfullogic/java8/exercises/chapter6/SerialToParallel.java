package com.insightfullogic.java8.exercises.chapter6;

import com.insightfullogic.java8.exercises.Exercises;

import java.util.stream.IntStream;

public class SerialToParallel {

    public static int sumOfSquares(IntStream range) {
        return range.parallel().map(operand -> operand * operand).sum();
    }

    public static int sequentialSumOfSquares(IntStream range) {
        return range.map(operand -> operand * operand).sum();
    }

}
