package com.jason.codepractise;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Jdk8Test {

    @Test
    public void testForEach() {
        Map<String, Integer> container = new HashMap<>();
        container.put("A", 1);
        container.put("B", 2);
        container.put("C", 3);
        container.put("D", 4);
        for(Map.Entry<String, Integer> entry: container.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("************");
        container.forEach(
                (k, v) -> System.out.println(k + ":" + v)
        );
        System.out.println("************");
        container.forEach((k, v)->{
                if (k.equals("A")) {
                    System.out.println(k + "-->" + v);
                }
        });
        System.out.println("************");
        List<String> items = new ArrayList<>();
        items.add("A");
        items.add("B");
        items.add("C");

        for (String item: items
             ) {
            System.out.println(item);
        }
        System.out.println("************");
        items.forEach(k-> System.out.println("hell"+ k));
        items.forEach(k-> {
            if (k.equals("A")) {
                System.out.println(k);
            }
        });
        items.forEach(System.out::println);
        items.stream().filter(s->s.contains("B"))
                .forEach(System.out::println);

    }
}
