package com.jason.codepractise.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * author: zhangkai
 * date: 2019-08-25
 * description:
 */
public class Run {
    static class Student {
        private Long id;
        private String name;
        private int age;
        private String addr;

        public Student(Long id, String name, int age, String addr) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.addr = addr;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    ", address='" + addr + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return age == student.age &&
                    Objects.equals(id, student.id) &&
                    Objects.equals(name, student.name) &&
                    Objects.equals(addr, student.addr);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name, age, addr);
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getAddr() {
            return addr;
        }

        public void setAddr(String addr) {
            this.addr = addr;
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student(1L, "肖战", 15, "浙江");
        Student s2 = new Student(2L, "王一博", 15, "湖北");
        Student s3 = new Student(3L, "杨紫", 17, "北京");
        Student s4 = new Student(4L, "李现", 17, "浙江");
        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        // testFilter(students);
        // testMap(students);

        testDistinct(students);
        // 排序 sorted()
        // 对象排序
        testSort(students);
        // limit(2) 限制个数
        // skip(2) 删除2个
        // reduce 聚合
        testReduce(students);
        // min  同sort  实现compare
        // 匹配  anyMatch/allMatch/noneMatch
        // Boolean b = students.stream().allMatch(s -> s.getAge()>=15);



    }

    public static void testReduce(List<Student> students) {
        List<String> list = Arrays.asList("欢", "迎", "你");
        String str = list.stream().reduce("北京", (a,b)->a+b);
        System.out.println(str);

    }
    /**
     * 先按照学生的id进行降序排序，再按照年龄进行降序排序
     * @param students
     */
    public static void testSort(List<Student> students) {
        students.stream().sorted((s1, s2) -> Long.compare(s1.getId(), s2.getId())).sorted((s1, s2) -> Integer.compare(s1.getAge(), s2.getAge())).forEach(System.out::println
        );
    }

    public static void testDistinct(List<Student> students) {
        List<String> lists = Arrays.asList("111", "222", "111", "444");
        lists.stream().distinct().forEach(System.out::println);
    }

    public static void testFilter(List<Student> students) {
        List<Student> ages = students.stream().filter(s -> s.getAge() > 15).collect(Collectors.toList());
        ages.forEach(System.out::println);
        students.stream().filter(s -> s.getAddr().equals("北京")).forEach(System.out::println);
    }

    /**
     * map就是将对应的元素按照给定的方法进行转换
     * @param students
     */
    public static void testMap(List<Student> students) {
        students.stream().map(s -> "年龄:" + s.getAddr()).collect(Collectors.toList()).forEach(System.out::println);
    }

}
