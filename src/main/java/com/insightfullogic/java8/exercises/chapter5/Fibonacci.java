package com.insightfullogic.java8.exercises.chapter5;

import com.insightfullogic.java8.exercises.Exercises;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Fibonacci {

    private static Map<Integer, Long> map = new HashMap<>();

    static {
        map.put(0, 0L);
        map.put(1, 1L);
    }

    public Fibonacci() {
    }

    public long fibonacci(int x) {
        return map.computeIfAbsent(x, integer -> fibonacci(integer - 1) + fibonacci(integer - 2));
    }
}
