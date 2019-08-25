package com.jason.codepractise.pattern.factory;

/**
 * author: zhangkai
 * date: 2019-08-25
 * description: 简单的工厂模式中，工厂根据输入的条件返回给一个接口的具体实现
 */
public class StaticFactory {
    public static void main(String[] args) {
        Dog dog = DogFactory.getDog("big");
        dog.speak();
        dog = DogFactory.getDog("small");
        dog.speak();
    }
}

interface Dog {
    void speak();
}
class Poodle implements Dog {
    @Override
    public void speak() {
        System.out.println("poodle...");
    }
}

class Rottweiler implements Dog {
    @Override
    public void speak() {
        System.out.println("Rottweiler.. ");
    }
}

class SiberianHusky implements Dog {
    @Override
    public void speak() {
        System.out.println("SiberianHusky...");
    }
}

class DogFactory {
    public static Dog getDog(String criteria) {
        if (criteria.equals("small")) {
            return new Poodle();
        } else if (criteria.equals("big")) {
            return new Rottweiler();
        }
        return null;
    }
}
