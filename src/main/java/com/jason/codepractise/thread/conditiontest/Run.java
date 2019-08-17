package com.jason.codepractise.thread.conditiontest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author: zhangkai
 * date: 2019-08-17
 * description:
 */
public class Run {
    public static void main(String[] args) throws InterruptedException{
        MyService service = new MyService();
        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();
        ThreadAA aa = new ThreadAA(service);
        aa.setName("AA");
        aa.start();
        Thread.sleep(100);
        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();
        ThreadBB bb = new ThreadBB(service);
        bb.setName("AA");
        bb.start();


    }
}

class MyService {
    private Lock lock = new ReentrantLock();

    public void methodA() {
        try {
            lock.lock();
            System.out.println("method A begin ThreadName = " + Thread.currentThread().getName() + " time " + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("method A end ThreadName = " + Thread.currentThread().getName() + " time " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void methodB() {
        try {
            lock.lock();
            System.out.println("method B begin ThreadName = " + Thread.currentThread().getName() + " time " + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("method B end ThreadName = " + Thread.currentThread().getName() + " time " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

class ThreadA extends Thread {
    private MyService myService;
    public ThreadA(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.methodA();
    }
}

class ThreadAA extends Thread {
    private MyService myService;
    public ThreadAA(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.methodA();
    }
}


class ThreadB extends Thread {
    private MyService myService;
    public ThreadB(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.methodB();
    }
}

class ThreadBB extends Thread {
    private MyService myService;
    public ThreadBB(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.methodB();
    }
}