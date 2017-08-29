package com.insightfullogic.java8.exercises.chapter5;

import com.insightfullogic.java8.examples.chapter1.Artist;
import com.insightfullogic.java8.exercises.Exercises;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class LongestName {

    public static Artist byReduce(List<Artist> artists) {
        return artists.stream()
                .reduce((artist, artist2) -> {
                    if (artist.getName().length() - artist2.getName().length() > 0) {
                        return artist;
                    } else {
                        return artist2;
                    }
                })
                .get();

    }

    public static Artist byCollecting(List<Artist> artists) {

        return artists.stream()
                .collect(Collectors.reducing((o, o2) -> o.getName().length() - o2.getName().length() > 0 ? o : o2))
                .get();
    }

}
