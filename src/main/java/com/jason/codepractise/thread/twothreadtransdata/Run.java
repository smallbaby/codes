package com.jason.codepractise.thread.twothreadtransdata;

import java.util.ArrayList;
import java.util.List;

class MyList {
    private List<String> list = new ArrayList<>();
    public void add() {
        list.add("hello");
    }
    public int size() {
        return list.size();
    }
}

class MyThread1 extends Thread {
    private MyList list;

    public MyThread1(MyList list) {
        this.list = list;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                list.add();
                System.out.println("添加了 " + (i+1) + " 个元素");
                Thread.sleep(1000);

            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread2 extends Thread {
    private MyList list;

    public MyThread2(MyList list) {
        this.list = list;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (list.size() == 5) {
                    System.out.println("==5 了，线程B该退出了。");
                    throw new InterruptedException();
                }
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Run {
    public static void main(String[] args) {
        MyList service = new MyList();
        MyThread1 myThread1 = new MyThread1(service);
        myThread1.setName("A");
        myThread1.start();
        MyThread2 myThread2 = new MyThread2(service);
        myThread2.setName("A");
        myThread2.start();
    }
}
