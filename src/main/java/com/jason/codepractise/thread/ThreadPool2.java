package com.jason.codepractise.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * 缓冲线程池实例-submit运行
 */
class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        System.out.println("call 被调用：" + Thread.currentThread().getName());
        //  模拟耗时
        for (int i = 999999; i > 0; i--) ;
        return "Call() 被自动调用，任务结果：" + this.id  + "   " + Thread.currentThread().getName();
    }
}

public class ThreadPool2 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> resultList = new ArrayList<>();
        // 创建10个任务并行
        for (int i = 0; i < 10; i++) {
            Future<String> future = executorService.submit(new TaskWithResult(i));
            resultList.add(future);
        }
        executorService.shutdown();
        for (Future<String> fs : resultList) {
            try {
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

}
