package com.jason.codepractise.leetcode;

import java.util.concurrent.CountDownLatch;

public class Foo {

    private CountDownLatch second = new CountDownLatch(1);
    private CountDownLatch third = new CountDownLatch(1);

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        second.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        second.await();
        printSecond.run();
        third.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        third.await();
        printThird.run();
    }

    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();
        foo.first(new Thread(new PrintRunnable(1)));
        foo.second(new Thread(new PrintRunnable(2)));
        foo.third(new Thread(new PrintRunnable(3)));

    }
}

class PrintRunnable implements Runnable {

    int i;

    public PrintRunnable(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println(this.i);
    }
}