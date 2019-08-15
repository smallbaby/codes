package com.jason.codepractise.thread.p_r_test.stack_1;

import org.springframework.cache.annotation.Cacheable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyStack {
    private List<String> list = new ArrayList<>();

    synchronized public void push() {
        try {
            if (list.size() == 1) {
                this.wait();
            }
            list.add("anyString:" + Math.random());
            this.notify();
            System.out.println("push=" + list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public String pop() {
        String returnValue = "";
        try {
            if (list.size() == 0) {
                System.out.println("POP操作中的 " + Thread.currentThread().getName() + " 线程呈wait状态.");
                this.wait();
            }
            returnValue = "" + list.get(0);
            list.remove(0);
            this.notify();
            System.out.println("POP=" + list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return returnValue;
    }

    public static void main(String[] args) {

    }
}

class Pp {
    private MyStack stack;

    public Pp(MyStack stack) {
        this.stack = stack;
    }

    public void pushService() {
        stack.push();
    }
}

class Cc {
    private MyStack stack;

    public Cc(MyStack stack) {
        this.stack = stack;
    }

    public void popService() {
        stack.pop();
    }
}

class Pt extends Thread {
    private Pp pp;

    public Pt(Pp pp) {
        this.pp = pp;
    }

    @Override
    public void run() {
        while (true) {
            pp.pushService();
        }
    }
}

class Ct extends Thread {
    private Cc cc;

    public Ct(Cc cc) {
        this.cc = cc;
    }

    @Override
    public void run() {
        while (true) {
            cc.popService();
        }
    }
}

