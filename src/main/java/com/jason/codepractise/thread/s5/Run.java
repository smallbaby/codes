package com.jason.codepractise.thread.s5;

import java.util.Date;

/**
 * @author: zhangkai
 * @date: 2019-08-16
 * @description:
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        ThreadA a = new ThreadA();
        a.start();
        Thread.sleep(1000);
        ThreadB b = new ThreadB();
        b.start();
    }
}

class Tool {
    public static ThreadLocal<Date> tl = new ThreadLocal<>();
}

class ThreadA extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                if (Tool.tl.get() == null) {
                    Tool.tl.set(new Date());
                }
                System.out.println("A " + Tool.tl.get().getTime());
                Thread.sleep(100);
            }
        }catch (InterruptedException e) {

        }
    }
}

class ThreadB extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                if (Tool.tl.get() == null) {
                    Tool.tl.set(new Date());
                }
                System.out.println(" " + Tool.tl.get().getTime());
                Thread.sleep(100);
            }
        }catch (InterruptedException e) {

        }
    }
}

