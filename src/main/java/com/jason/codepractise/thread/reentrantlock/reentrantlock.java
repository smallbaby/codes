package com.jason.codepractise.thread.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author: zhangkai
 * date: 2019-08-17
 * description:
 */
public class reentrantlock {
    public static void main(String[] args) {
        MyService service = new MyService();
        ThreadA a = new ThreadA(service);
        ThreadA b = new ThreadA(service);
        ThreadA c = new ThreadA(service);
        ThreadA d = new ThreadA(service);
        ThreadA e = new ThreadA(service);
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }
}

class MyService {
    private Lock lock = new ReentrantLock();
    public void testMethod() {
        lock.lock();
        for (int i = 0; i < 5; i++) {
            System.out.println("ThreadName=" + Thread.currentThread().getName() + " " + (i + 1));
        }
        lock.unlock();
    }
}

class ThreadA extends Thread {
    private MyService myService;

    public ThreadA(MyService service) {
        this.myService = service;
    }

    @Override
    public void run() {
        myService.testMethod();
    }
}

