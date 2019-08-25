package com.jason.codepractise.thread.factory;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * author: zhangkai
 * date: 2019-08-25
 * description:
 */
public class Run {
    public static void main(String[] args) {
        System.out.println("main thread beginning...");
        ThreadFactoryAuto.MyThreadFactory factory = new ThreadFactoryAuto.MyThreadFactory("myThreadFactory");
        Thread thread = null;
        for (int i = 0; i < 10; i++) {
            thread = factory.newThread(new ThreadFactoryAuto.MyTask(i));
            thread.run();
        }
        System.out.printf("Factory stats:\n");
        System.out.printf("%s\n", factory.getStats());
        System.out.println("main thread ending....");
    }
}


interface JasonThreadFactory {
    Thread newThread(Runnable r);
}

/**
 * 线程池中默认的线程工厂实现
 */
class DefaultThreadFactory implements JasonThreadFactory {
    private static final AtomicInteger poolNumber = new AtomicInteger(1); // 原子类，线程池编号
    private static ThreadGroup group; // 线程组
    private final AtomicInteger threadNumber = new AtomicInteger(1); // 线程数目
    private static String namePrefix; //线程名前缀

    DefaultThreadFactory() {
        SecurityManager s = System.getSecurityManager();
        group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup(); //获取线程组
        namePrefix = "pool-" + poolNumber.getAndIncrement() + "-thread-";
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(group, r, namePrefix + threadNumber.getAndIncrement(), 0);
        if (t.isDaemon())
            t.setDaemon(false);
        if (t.getPriority() != Thread.NORM_PRIORITY)
            t.setPriority(Thread.NORM_PRIORITY);
        return t;
    }
}


class ThreadFactoryAuto {
    static class MyThreadFactory implements ThreadFactory {
        private int counter;
        private String name;
        private List<String> stats;

        public MyThreadFactory(String name) {
            counter = 0;
            this.name = name;
            stats = new ArrayList<>();
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, name + "-Thread-" + counter);
            counter++;
            stats.add(String.format("Created thread %d with name %s on %s\n", t.getId(), t.getName(), new Date()));
            return t;
        }

        public String getStats() {
            StringBuilder buffer = new StringBuilder();
            Iterator<String> it = stats.iterator();
            while (it.hasNext()) {
                buffer.append(it.next());
                buffer.append("\n");
            }
            return buffer.toString();
        }
    }

    static class MyTask implements Runnable {
        private int num;

        public MyTask(int num) {
            this.num = num;
        }

        @Override
        public void run() {
            System.out.println("Task " + num + " is running..");
            try {
                Thread.sleep(2 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


