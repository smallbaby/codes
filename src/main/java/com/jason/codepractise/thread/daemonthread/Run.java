package com.jason.codepractise.thread.daemonthread;

class MyThread extends Thread {
    private int i = 0;

    @Override
    public void run() {
        try {
            while (true) {
                i ++;
                System.out.println("i=" + i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


public class Run {
    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.setDaemon(true);
            thread.sleep(5000);
            System.out.println("我离开thread对象也不再打印了，也就是停止了.");
        }catch (InterruptedException e) {

        }
    }
}
