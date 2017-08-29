package com.insightfullogic.java8.exercises.chapter5;

import com.insightfullogic.java8.exercises.Exercises;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class GroupingBy<T, K> implements Collector<T, Map<K, List<T>>, Map<K, List<T>>> {

    private static Set<Characteristics> characteristicsSet = new HashSet<>();
    private final Function<? super T, ? extends K> classifier;

    static {
        characteristicsSet.add(Characteristics.IDENTITY_FINISH);
    }

    //将 T 按照 K 分类，构造函数参数是一个接收 T 作为参数并返回 K 的函数
    public GroupingBy(Function<? super T, ? extends K> classifier) {
        this.classifier = classifier;
    }

    @Override
    public Supplier<Map<K, List<T>>> supplier() {
        return HashMap::new;
    }

    @Override
    public BiConsumer<Map<K, List<T>>, T> accumulator() {
        return (kListMap, t) -> {
            K key = classifier.apply(t); // 计算 K key 的值
            // 从 map 中取出 list，必要时新建空 list
            List<T> elements = kListMap.computeIfAbsent(key, k -> new ArrayList<T>());
            elements.add(t);
        };
    }

    @Override
    public BinaryOperator<Map<K, List<T>>> combiner() {
        return (left, right) -> {
            // 合并两个 map
            left.forEach((key, value) -> {
                right.merge(key, value, (oldValue, newValue) -> {
                            oldValue.addAll(newValue);
                            return oldValue;
                        }
                );
            });
            return right;
        };
    }

    @Override
    public Function<Map<K, List<T>>, Map<K, List<T>>> finisher() {
        return kListMap -> kListMap;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return characteristicsSet;
    }

}
