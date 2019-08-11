package com.jason.codepractise.thread;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

/**
 * 总结：
 *
 * ThreadPoolExecutor中，包含了一个任务缓存队列和若干个执行线程，任务缓存队列是一个大小固定的缓冲区队列，用来缓存待执行的任务，执行线程用来处理待执行的任务。每个待执行的任务，都必须实现Runnable接口，执行线程调用其run()方法，完成相应任务。
 * ThreadPoolExecutor对象初始化时，不创建任何执行线程，当有新任务进来时，才会创建执行线程。
 * 构造ThreadPoolExecutor对象时，需要配置该对象的核心线程池大小和最大线程池大小：
 * 当目前执行线程的总数小于核心线程大小时，所有新加入的任务，都在新线程中处理
 * 当目前执行线程的总数大于或等于核心线程时，所有新加入的任务，都放入任务缓存队列中
 * 当目前执行线程的总数大于或等于核心线程，并且缓存队列已满，同时此时线程总数小于线程池的最大大小，那么创建新线程，加入线程池中，协助处理新的任务。
 * 当所有线程都在执行，线程池大小已经达到上限，并且缓存队列已满时，就rejectHandler拒绝新的任务
 */

class Handler implements Runnable {
    private String name;

    public Handler(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " Start. Time = " + new Date());
        processCommand();
        System.out.println(name + " End. Time = " + new Date());

    }

    private void processCommand() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}

class MyHandle implements Runnable {

    @Override
    public void run() {
        System.out.println(System.currentTimeMillis());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

public class First {


    public void extraTest() {
        int POOL_SIZE = 10;
        // 建立线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 或者
        int cupNums = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService1 = Executors.newFixedThreadPool(cupNums * POOL_SIZE);
    }

    /**
     * 固定大小的线程池，最多并行5个同时执行
     * 不保证顺序
     */
    private static void testFixedThreadPool() {
        System.out.println("Main. start at. " + new Date());
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Handler(String.valueOf(i)));
        }
        executorService.shutdown();
        System.out.println("Main. end at. " + new Date());
    }

    /**
     * 一个线程的线程池，能保证线程的先后顺序，一条执行完再开启新的。
     * 等价于：ExecutorService exec = Executors.newFixedThreadPool(1);
     */
    private static void testNewSingleThreadExecutor() {
        System.out.println("Main Start at " + new Date());
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Handler(String.valueOf(i)));
        }
        executorService.shutdown();
        System.out.println("Main End at " + new Date());
    }

    /**
     * 计划线程池，放入的线程延迟10秒开始执行
     */
    private static void testNewScheduledThreadPool() {
        System.out.println("Main Start at " + new Date());
        ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(10);
        for (int i = 0; i < 20; i++) {
            executor.schedule(new Handler(String.valueOf(i)), 5, TimeUnit.SECONDS);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
            // wait for all tasks to finish
        }
        System.out.println("Main End at " + new Date());
    }

    private static void tetCachedThreadPool() {
        // 主线程和线程池的执行是分开的
        // 并不按照前后顺序执行
        System.out.println("Main Start at " + new Date());
        ExecutorService exec = Executors.newCachedThreadPool(); // 创建一个缓冲池，大小为Integer.MAX_VALUE
        for (int i = 0; i < 10; i++) {
            exec.execute(new Handler(String.valueOf(i)));
        }
        exec.shutdown();
        System.out.println("Main. Finished all threads at " + new Date());
    }

    /**
     * 初始化延迟0ms开始执行，每隔2000ms重新执行一次任务
     */
    private static void testExecuteFixedRate() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);
        executorService.scheduleAtFixedRate(new MyHandle(), 0, 1000, TimeUnit.MILLISECONDS);
    }

    /**
     * 获取指定时间对应的毫秒数
     *
     * @param time "HH:mm:ss"
     * @return
     */
    private static long getTimeMillis(String time) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
            DateFormat dayFormat = new SimpleDateFormat("yy-MM-dd");
            Date curDate = dateFormat.parse(dayFormat.format(new Date()) + " " + time);
            return curDate.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 指定间隔执行任务
     * 间隔指的是连续上次执行完成和下次开始执行之间的间隔
     */
    private static void testExecuteFixedDelay() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);
        executorService.scheduleWithFixedDelay(new MyHandle(), 0, 200, TimeUnit.MILLISECONDS);
    }

    /**
     * 每天晚上9点执行一次
     */
    private static void testExecuteEightAtNightPerDay() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        long oneDay = 24 * 60 * 60 * 1000;
        long initDelay = getTimeMillis("21:00:00") - System.currentTimeMillis();
        initDelay = initDelay > 0 ? initDelay : oneDay + initDelay;
        scheduledExecutorService.scheduleAtFixedRate(new MyHandle(), initDelay, oneDay, TimeUnit.MILLISECONDS);

    }


    public static void main(String[] args) {
        First.testExecuteFixedDelay();
    }
}



