package com.jason.codepractise.thread.suspendresume;

class MyThread extends Thread {
    private long i = 0;

    public long getI() {
        return i;
    }

    public void setI(long i) {
        this.i = i;
    }

    @Override
    public void run() {
        while(true) {
            i ++;
        }
    }
}

public class SusendThread {
    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.start();
            Thread.sleep(1000);
            //
            thread.suspend();
            System.out.println("A = " + System.currentTimeMillis() + " i = " + thread.getI());
            thread.sleep(5000);
            System.out.println("A = " + System.currentTimeMillis() + " i = " + thread.getI());
            //
            thread.resume();
            thread.sleep(5000);
            thread.suspend();
            System.out.println("B = " + System.currentTimeMillis() + " i = " + thread.getI());
            thread.sleep(5000);
            System.out.println("B = " + System.currentTimeMillis() + " i = " + thread.getI());

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
