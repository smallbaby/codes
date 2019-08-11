package com.jason.codepractise;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

class Door {
    private String name;
    private String no;

    public Door(String name, String no) {
        this.name = name;
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "User name" + this.name + "\t no:" + this.no;
    }
}


public abstract class JsonStr {

    public static Predicate<String> ofLength10 = new Predicate<String>() {
        @Override
        public boolean test(String s) {
            return s.length() == 10;
        }
    };

    public static Predicate<String> nonNULLPredicate = Objects::nonNull;


    private JsonStr() {
    }

    static void pred(int number, Predicate<Integer> predicate) {
        if (predicate.test(number)) {
            System.out.println("number:" + number);
        }
    }


    public static boolean predicatTest(Integer item) {
        Predicate<Integer> GENDER_RANGE_LEFT = x -> (x >= 18);
        Predicate<Integer> GENDER_RANGE_RIGHT = x -> (x <= 100);
        boolean test = GENDER_RANGE_LEFT.test(100); // 单条件判断
        boolean negateTest = GENDER_RANGE_LEFT.and(GENDER_RANGE_RIGHT).negate().test(item); // 相反
        System.out.println(test);
        System.out.println(negateTest);
        return GENDER_RANGE_LEFT.and(GENDER_RANGE_RIGHT).test(item); // 组合
    }


    public static List<Door> process(List<Door> doors, Predicate<Door> predicate) {
        List<Door> res = new ArrayList<>();
        doors.forEach(door -> {
            if (predicate.test(door)) {
                res.add(door);
            }
        });
        return res;
    }

    public static void main(String[] args) {
        boolean b = JsonStr.predicatTest(19);
        System.out.println(b);
        JsonStr.pred(2, x -> (x > 5));

        List<Door> doors = new ArrayList<>();
        doors.add(new Door("a", "b"));
        doors.add(new Door("b", "bb"));
        doors.add(new Door("c", "bbbb"));

        List<Door> ds = JsonStr.process(doors, (Door door) -> door.getName().equals("a"));
        System.out.println(ds);

        // Consumer
        Consumer<String> c = (x) -> System.out.println(x.toLowerCase());
        c.andThen(c).accept("HELLO");


    }

}
