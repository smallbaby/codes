package com.jason.codepractise.thread.t8;

class Task {
    synchronized public void otherMethod() {
        System.out.println("------------run - otherMethod.");
    }

    public void doLongTimeTask() {
        synchronized (this) {
            for (int i = 0; i < 10000; i++) {
                System.out.println("synchronized threadName=" + Thread.currentThread().getName() + " i = " + (i + 1));
            }
        }
    }
}

class MyThread1 extends Thread {
    private Task task;
    public MyThread1(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        super.run();
        task.doLongTimeTask();
    }
}
class MyThread2 extends Thread {
    private Task task;
    public MyThread2(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        super.run();
        task.otherMethod();
    }
}


public class Run {
    public static void main(String[] args) {
        Task task = new Task();
        MyThread1 myThread1 = new MyThread1(task);
        myThread1.start();
        MyThread2 myThread2 = new MyThread2(task);
        myThread2.start();
    }
}
