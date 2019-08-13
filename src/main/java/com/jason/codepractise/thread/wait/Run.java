package com.jason.codepractise.thread.wait;


class MyThread1 extends Thread {
    private Object lock;

    public MyThread1(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                System.out.println("开始 wait time= " + System.currentTimeMillis());
                lock.wait();
                System.out.println("结束 wait time=" + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread2 extends Thread {
    private Object lock;

    public MyThread2(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println("开始 notify time= " + System.currentTimeMillis());
            lock.notify();
            System.out.println("结束 notify time=" + System.currentTimeMillis());
        }
    }
}

public class Run {

    public static void test3() {
        try {
            Object lock = new Object();
            MyThread1 t1 = new MyThread1(lock);
            t1.start();
            Thread.sleep(1000);
            MyThread2 t2 = new MyThread2(lock);
            t2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void test2() {
        try {
            String lock = new String();
            System.out.println("syn 上面");
            synchronized (lock) {
                System.out.println("sys第一行");
                lock.wait();
                System.out.println("wait下的代码");
            }
            System.out.println("sys下面的代码");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void test1() {
        try {

            String newString = new String("");
            newString.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        // throws
        //Run.test1();
        // sysn
        // Run.test2();
        //wait nofity
        Run.test3();
    }
}
