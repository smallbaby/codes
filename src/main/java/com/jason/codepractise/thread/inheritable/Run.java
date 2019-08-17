package com.jason.codepractise.thread.inheritable;

import com.jason.codepractise.thread.p_r_test.P;

import java.util.Date;

/**
 * author: zhangkai
 * date: 2019-08-16
 * description:
 */
public class Run {
    public static void main(String[] args) {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("在Main中获得值: " + Tools.threadLocalExt.get());
                Thread.sleep(1000);
            }
            Thread.sleep(5000);
            ThreadA a = new ThreadA();
            a.start();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class InheritableThreadLocalExt extends InheritableThreadLocal {
    @Override
    protected Object initialValue() {
        return new Date().getTime();
    }
}

class Tools {
    public static InheritableThreadLocalExt threadLocalExt = new InheritableThreadLocalExt();
}

class ThreadA extends Thread {
    @Override
    public void run() {
        try {


            for (int i = 0; i < 10; i++) {
                System.out.println("ThreadA value=" + Tools.threadLocalExt.get());
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
