package com.jason.codepractise.thread.factory;

import org.apache.tomcat.util.ExceptionUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * author: zhangkai
 * date: 2019-08-25
 * description:
 *
 * Task 0 local num result is 8
 * Task 0 local num result is 9
 * Task 4 local num result is 7
 * Task 4 local num result is 8
 * Task 4 local num result is 9
 * 相互不影响
 * ThreadLocal为每个使用该变量的线程提供独立的变量副本，所以每一个线程都可以独立地改变自己的副本，而不会影响其它线程所对应的副本
 * 每一个线程都有自己一个ThreadLocalMap
 *
 */

public class ThreadLocalTest {
    static final ThreadLocal<Integer> local = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    static class Task implements Runnable {
        private int num;

        public Task(int num) {
            this.num = num;
        }

        @Override
        public void run() {
            Integer i = local.get();
            while (++i < 10) {
                System.out.println("Task " + num + " local num result is " + i);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("main thread beginning...");
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new Task(i));
        }
        executorService.shutdown();
        System.out.println("main thread end....");
    }

}

