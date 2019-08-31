package com.jason.codepractise.datastructure.sort;

/**
 * author: zhangkai
 * date: 2019-08-28
 * description:
 */
public class ArrayBub {
    private long[] a;
    private int nItems;
    public ArrayBub(int maxSize) {
        a = new long[maxSize];
        nItems = 0;
    }

    public void insert(long value) {
        a[nItems++] = value;
    }

    public void display() {
        for (int i = 0; i < nItems; i++)
            System.out.print(a[i] + "\t");
        System.out.println();
    }

    public void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }

    public void bubbleSort() {
        for (int out = nItems-1; out > 1; out--) {
            for (int in = 0; in < out; in++) {
                if (a[in] > a[in + 1]) {
                    swap(in, in + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int maxSize = 10;
        ArrayBub ab = new ArrayBub(maxSize);
        ab.insert(3);
        ab.insert(5);
        ab.insert(1);
        ab.insert(2);
        ab.insert(10);
        ab.insert(50);
        ab.insert(3);
        ab.display();
        ab.bubbleSort();
        ab.display();
    }
}
