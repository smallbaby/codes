package com.jason.codepractise.thread.study;

import java.lang.annotation.Target;

class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("MyThread.");
    }
}

class MyThread1 extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                int time = (int) (Math.random() * 10);
                Thread.sleep(time);
                System.out.println("run:" + Thread.currentThread().getName());
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyRunable implements Runnable {
    @Override
    public void run() {
        System.out.println("运作中...");
    }
}


class MyThread2 extends Thread {
    private int count = 5;
    public MyThread2(String name) {
        super();
        this.setName(name);
    }

    @Override
    synchronized public void run() {
        super.run();
        //while (count > 0) {
            count--;
            System.out.println("由 " + Thread.currentThread().getName() + " 计算, count=" + count);
        //}
    }
}



public class Main {

    private static void testThreadShareVar() {
        MyThread2 a = new MyThread2("A");
        MyThread2 b = new MyThread2("B");
        MyThread2 c = new MyThread2("C");
        a.start();
        b.start();
        c.start();
    }

    private static void testRandomThread() {
        MyThread1 myThread1 = new MyThread1();
        myThread1.setName("MyThread.");
        myThread1.start();
        try {
            for (int i = 0; i < 10; i++) {
                int time = (int) (Math.random() * 10);
                Thread.sleep(time);
                System.out.println("main:" + Thread.currentThread().getName());
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        // extends thread.
        new MyThread().start();
        // 名称随机性测试
        Main.testRandomThread();
        // implements runnable..
        new Thread(new MyRunable()).start();
        // 测试共享变量
        Main.testThreadShareVar();


    }
}
