package com.jason.codepractise.thread.threadlocal;

/**
 * ThreadLocal解决的是不同线程之间变量的隔离性.
 * 不同线程拥有自己的值.
 */
public class Run {
    public static ThreadLocal threadLocal = new ThreadLocal();

    public static void testLocal() {
        if(threadLocal.get() == null) {
            System.out.println("从未放过值.");
            threadLocal.set("helloworld");
        }
        System.out.println(threadLocal.get());
        System.out.println(threadLocal.get());
        System.out.println(threadLocal.get());
    }


    public static void testMutlLocal() {
        try {
            ThreadA a = new ThreadA();
            ThreadB b = new ThreadB();
            a.start();
            b.start();
            for (int i = 0; i < 10; i++) {
                Tool.tl.set("Main" + (i + 1));
                System.out.println("Main get value = " + Tool.tl.get());
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Run.testLocal();
        Run.testMutlLocal();
    }
}


class Tool {
    public static ThreadLocal tl = new ThreadLocal();
}

class ThreadA extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                Tool.tl.set("ThreadA + " + i);
                System.out.println("ThreadA get value=" + Tool.tl
                .get());
                Thread.sleep(200);
            }

        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadB extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                Tool.tl.set("ThreadB + " + i);
                System.out.println("ThreadB get value=" + Tool.tl
                        .get());
                Thread.sleep(200);
            }

        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}





