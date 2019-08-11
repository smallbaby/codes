package com.jason.codepractise;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class MyFunction implements Function<String, Integer> {
    @Override
    public Integer apply(String s) {
        return s.length();
    }
}

class Student {
    private int id;
    public double gpa;
    private String name;

    Student(int id, long g, String name) {
        this.id = id;
        this.gpa = g;
        this.name = name;
    }

    @Override
    public String toString() {
        return id + ">" + name + ": " + gpa;
    }
}

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

    @Test
    public void consumerOneTest() {
        Consumer<String> s = (x) -> System.out.println(x.toLowerCase());
        s.accept("Hello");
    }

    public static void raiseStudents(List<Student> students, Consumer<Student> fx) {
        for (Student stu : students) {
            fx.accept(stu);
        }
    }

    @Test
    public void consumerTwoTest() {
        List<Student> stus = Arrays.asList(
                new Student(1, 1, "zhangkai"),
                new Student(2, 2, "lisi"),
                new Student(3, 3, "wangwu"));

        Consumer<Student> raiser = e -> {
            e.gpa = e.gpa * 1.1;
        };
        raiseStudents(stus, System.out::println);
        raiseStudents(stus, raiser.andThen(System.out::println));
    }

    @Test
    public void functionTest() {
        Function<Integer, Integer> func = p -> p * 3;
        Function<Integer, Integer> square = e -> e * e;

        int value = func.andThen(square).apply(2);
        Assert.assertEquals(value, 36); // 2 * 3 = 6 => 6 * 6

        int value1 = func.compose(square).apply(2);
        Assert.assertEquals(value1, 12);

        Object identity = Function.identity().apply("hello");
        Assert.assertEquals(identity, "hello");


    }


}
