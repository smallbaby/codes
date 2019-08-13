package com.jason.codepractise.thread.t9;

import java.util.ArrayList;
import java.util.List;

class MyObject {
    private List<String> list = new ArrayList<>();
    synchronized public void add(String data) {
        list.add(data);
    }
    synchronized public int getSize() {
        return list.size();
    }
}

class MyService {
    public MyObject addServiceMethod(MyObject list, String data) {
        try {
            synchronized (list) {
                if (list.getSize() < 1) {
                    Thread.sleep(2000);
                    list.add(data);
                }
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        return list;
    }
}

class MyThread extends Thread {
    private MyObject list;
    public MyThread(MyObject list) {
        this.list = list;
    }

    @Override
    public void run() {
        MyService msRef = new MyService();
        msRef.addServiceMethod(list, "A");
    }
}
class MyThread1 extends Thread {
    private MyObject list;
    public MyThread1(MyObject list) {
        this.list = list;
    }

    @Override
    public void run() {
        MyService msRef = new MyService();
        msRef.addServiceMethod(list, "B");
    }
}


public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyObject list = new MyObject();
        MyThread myThread = new MyThread(list);
        myThread.setName("A");
        myThread.start();
        MyThread1 myThread1 = new MyThread1(list);
        myThread1.setName("B");
        myThread1.start();
        Thread.sleep(6000);
        System.out.println("listSize=" + list.getSize());
    }
}



