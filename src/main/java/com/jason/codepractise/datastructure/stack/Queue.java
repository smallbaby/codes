package com.jason.codepractise.datastructure.stack;

/**
 * author: zhangkai
 * date: 2019-09-09
 * description:
 */
public class Queue {
    private int[] arr; // 队列容器
    private int maxSize; // 长度
    private int tail; // 尾
    private int head; // 头
    private int length; // 数组实际应用的长度

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        head = 0;
        tail = -1;
        length = 0;
    }

    public void insert(int element) throws Exception {
        if (length == maxSize) {
            throw new Exception("队列已满");
        }
        if (tail == maxSize - 1) {
            tail = -1;
        }
        arr[++tail] = element;
        length++;
    }

    public int remove() throws Exception {
        if (length == 0) {
            throw new Exception("队列为空");
        }
        int element = arr[head++];
        if (head == maxSize) {
            head = 0;
        }
        length--;
        return element;
    }
    public int peek() throws Exception {
        if (length == 0) {
            throw new Exception("队列为空.");
        }
        return arr[head];
    }
    public boolean isEmpty() {
        return length == 0;
    }
    public boolean isFull() {
        return length == maxSize;
    }

}
