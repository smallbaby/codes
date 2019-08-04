package com.jason.codepractise;


import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch 是JUC中的一个类，多个线程达到
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        CountDownLatch await = new CountDownLatch(5);

        for (int i = 0; i < 5; i++) {
            new Thread(new MyRunnable(countDownLatch, await)).start();
        }
        System.out.println("用于触发处于等待状态的线程开始工作....");
        System.out.println("用于触发处于等待状态的线程工作完成，等待状态线程开始工作...");
        countDownLatch.countDown();
        await.await();
        System.out.println("Nice....");
    }
}

class MyRunnable implements Runnable {

    private final CountDownLatch countDownLatch;
    private final CountDownLatch await;

    public MyRunnable(CountDownLatch countDownLatch, CountDownLatch await) {
        this.countDownLatch = countDownLatch;
        this.await = await;
    }

    @Override
    public void run() {
        try {
            countDownLatch.await(); // 等待主线程执行完毕，获取开始执行的信号...
            System.out.println("处于等待状态的线程开始自己预期工作....");
            await.countDown(); // 完成预期工作，发出完成信号
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
