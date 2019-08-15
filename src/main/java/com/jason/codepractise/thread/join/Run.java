package com.jason.codepractise.thread.join;

/**
 * join是等待其他线程销毁
 * join(long) 设置等待时长
 */

class MyThread extends Thread {
    @Override
    public void run() {
        try {
            int secondValue = (int) (Math.random() * 1000);
            System.out.println(secondValue);
            Thread.sleep(secondValue);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyThread mt = new MyThread();
        mt.start();
        mt.join();
        System.out.println("我想等你执行完在执行。");
    }
}
