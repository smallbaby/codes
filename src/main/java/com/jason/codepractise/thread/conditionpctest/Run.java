package com.jason.codepractise.thread.conditionpctest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author: zhangkai
 * date: 2019-08-17
 * description:
 */
public class Run {
    public static void main(String[] args) {
        MyService service = new MyService();
        ThreadA a = new ThreadA(service);
        a.start();
        ThreadB b = new ThreadB(service);
        b.start();
    }
}

class MyService {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean hasValue = false;
    public void set() {
        try {
            lock.lock();
            while (hasValue == true) {
                condition.await();
            }
            System.out.println("答应💟");
            hasValue = true;
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void get() {
        try {
            lock.lock();
            while (hasValue == false) {
                condition.await();
            }
            System.out.println("打印☆");
            hasValue = false;
            condition.signal();
        }catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}


class ThreadA extends Thread {
    private MyService myService;
    public ThreadA(MyService service) {
        this.myService = service;
    }

    @Override
    public void run() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            myService.set();
        }
    }
}

class ThreadB extends Thread {
    private MyService myService;
    public ThreadB(MyService service) {
        this.myService = service;
    }

    @Override
    public void run() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            myService.get();
        }
    }
}