package com.insightfullogic.java8.exercises.chapter3;

import com.insightfullogic.java8.exercises.Exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Advanced Exercises Question 2
 */
public class MapUsingReduce {

    public static <I, O> List<O> map(Stream<I> stream, Function<I, O> mapper) {
        return stream.reduce(Collections.emptyList(), (os, i) -> {
                    List<O> o = new ArrayList<>(os);
                    o.add(mapper.apply(i));
                    return o;
                },
                (os, os2) -> {
                    List<O> o = new ArrayList<>(os);
                    o.addAll(os2);
                    return o;
                }
        );
    }

}
