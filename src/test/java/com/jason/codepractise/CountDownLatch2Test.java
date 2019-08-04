package com.jason.codepractise;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CountDownLatch2Test {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 10, 100, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(5));
        int count = 10;
        final CountDownLatch latch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            threadPool.execute(new TestRunnable(latch, i));
        }
        latch.await();
        System.out.println("等待线程被唤醒...");
        threadPool.shutdown();
    }
}

class TestRunnable implements Runnable {

    CountDownLatch latch = null;
    int i;

    public TestRunnable(CountDownLatch latch, int i) {
        this.latch = latch;
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println("线程" + i + " 完成了操作....");
        try {
            Thread.currentThread();
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        latch.countDown();
    }
}
