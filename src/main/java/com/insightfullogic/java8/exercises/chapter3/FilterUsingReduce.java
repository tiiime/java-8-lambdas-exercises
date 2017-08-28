package com.insightfullogic.java8.exercises.chapter3;

import com.insightfullogic.java8.exercises.Exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Advanced Exercises Question 1
 */
public class FilterUsingReduce {

    public static <I> List<I> filter(Stream<I> stream, Predicate<I> predicate) {
        return stream.reduce(Collections.<I>emptyList(), (List<I> is, I i) -> {
            if (predicate.test(i)) {
                List<I> l = new ArrayList<>(is);
                l.add(i);
                return l;
            } else {
                return is;
            }
        }, (is, is2) -> {
            List<I> newLeft = new ArrayList<>(is);
            newLeft.addAll(is2);
            return newLeft;
        });
    }

}
