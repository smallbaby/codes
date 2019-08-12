package com.jason.codepractise.thread.suspendresume;


public class SynchronizedObject {
    synchronized public void printString() {
        System.out.println("Begin.");
        if (Thread.currentThread().getName().equals("a")) {
            System.out.println("a 线程永远 suspend 了.");
            Thread.currentThread().suspend();
        }
        System.out.println("End.");
    }

    public static void main(String[] args) {
        try {
            final SynchronizedObject object = new SynchronizedObject();
            Thread thread = new Thread() {
                @Override
                public void run() {
                    object.printString();
                }
            };
            thread.setName("a");
            thread.start();
            Thread.sleep(1000);
            Thread thread2 = new Thread() {
                @Override
                public void run() {
                    System.out.println("thread2 启动了，但进入不了printString() 方法！只打印1个Begin.");
                    System.out.println("因为pringtString() 方法被a线程锁定并且永远suspend暂停了.");
                    object.printString();
                }
            };
            thread2.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
