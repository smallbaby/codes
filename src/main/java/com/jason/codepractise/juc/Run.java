package com.jason.codepractise.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * author: zhangkai
 * date: 2019-08-19
 * description:
 */
public class Run {
    public static void main(String[] args) {
        ArrayBlockingQueue a;
        AbstractQueuedSynchronizer aqs;
    }

    /**
     * 挂起当前线程，直到所有线程到达屏障状态后，再同时执行后续任务
     */
    public static void test1() {
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
    }
}
