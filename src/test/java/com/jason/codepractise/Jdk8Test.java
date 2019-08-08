package com.jason.codepractise;

import org.junit.Test;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Jdk8Test {

    @Test
    public void testForEach() {
        Map<String, Integer> container = new HashMap<>();
        container.put("A", 1);
        container.put("B", 2);
        container.put("C", 3);
        container.put("D", 4);
        for (Map.Entry<String, Integer> entry : container.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("************");
        container.forEach(
                (k, v) -> System.out.println(k + ":" + v)
        );
        System.out.println("************");
        container.forEach((k, v) -> {
            if (k.equals("A")) {
                System.out.println(k + "-->" + v);
            }
        });
        System.out.println("************");
        List<String> items = new ArrayList<>();
        items.add("A");
        items.add("B");
        items.add("C");

        for (String item : items
        ) {
            System.out.println(item);
        }
        System.out.println("************");
        items.forEach(k -> System.out.println("hell" + k));
        items.forEach(k -> {
            if (k.equals("A")) {
                System.out.println(k);
            }
        });
        items.forEach(System.out::println);
        items.stream().filter(s -> s.contains("B"))
                .forEach(System.out::println);

    }

    @Test
    public void testStream() {
        List<Integer> list = Stream.of(1, 2, 3, 4).collect(Collectors.toList());
        System.out.println(list);
        Set<Integer> set = Stream.of(1, 2, 3, 4).collect(Collectors.toSet());
        List<String> collected = Stream.of("a", "b", "c").map(string -> string.toLowerCase()).collect(Collectors.toList());

        List<String> filterList = Stream.of("a", "b", "c").filter(value -> value.equals("a")).collect(Collectors.toList());
    }

    @Test
    public void predicateTest() {
        Predicate<Integer> atLeast5 = x -> x > 5;
        BinaryOperator<Long> addLongs = (x, y) -> x + y;
    }

}
