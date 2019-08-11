package com.jason.codepractise.thread.threadsafe;

/**
 * 非线程安全
 */
class MyThread extends Thread {
    private int i = 5;
    @Override
    public void run() {
        System.out.println("i=" + (i--) + " threadName=" + Thread.currentThread().getName());
    }
}

public class SameNum {
    public static void main(String[] args) {
        MyThread run = new MyThread();
        Thread t1 = new Thread(run);
        Thread t2 = new Thread(run);
        Thread t3 = new Thread(run);
        Thread t4 = new Thread(run);
        System.out.println("Thread-t1 isAlive=" + t1.isAlive());
        t1.start();
        System.out.println("Thread-t1 isAlive=" + t1.isAlive());
        t2.start();
        t3.start();
        t4.start();
    }
}
