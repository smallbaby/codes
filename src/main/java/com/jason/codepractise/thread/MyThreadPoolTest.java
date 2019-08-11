package com.jason.codepractise.thread;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.io.Serializable;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThreadPoolTest {
    private static int produceTaskSleepTime = 2;
    private static int produceTaskMaxNumber = 10;

    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2,
                4, 3, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardOldestPolicy());
        for (int i = 0; i < produceTaskMaxNumber; i++) {
            try {
                String task = "task@" + i;
                System.out.println("put " + task);
                threadPool.execute(new ThreadPoolTask(task));
                Thread.sleep(produceTaskSleepTime);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class ThreadPoolTask implements Runnable, Serializable {
    private static final long serialVersionUID = 0;
    private static int consumeTaskSleepTime = 2000;
    private Object threadPoolTaskData;

    ThreadPoolTask(Object tasks) {
        this.threadPoolTaskData = tasks;
    }

    public Object getTask() {
        return this.threadPoolTaskData;
    }

    @Override
    public void run() {
        System.out.println("current task:" + Thread.currentThread().getName());
        System.out.println("start." + threadPoolTaskData);
        try {
            Thread.sleep(consumeTaskSleepTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
