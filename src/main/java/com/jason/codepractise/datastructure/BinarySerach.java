package com.jason.codepractise.datastructure;

import com.sun.tools.corba.se.idl.constExpr.Or;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * author: zhangkai
 * date: 2019-08-21
 * description:
 */


class OrdArray {
    private long[] a;
    private int nItems;

    public OrdArray(int max) {
        a = new long[max];
        nItems = 0;
    }

    public int size() {
        return nItems;
    }

    public int find(long searchKey) {
        int lowBound = 0;
        int upperBound = nItems - 1;
        int currIn;
        while (true) {
            currIn = (lowBound + upperBound) / 2;
            if (a[currIn] == searchKey) {
                return currIn;
            } else if (lowBound > upperBound) {
                return nItems;
            } else {
                if (a[currIn] < searchKey) {
                    lowBound = currIn + 1;
                } else {
                    upperBound = currIn - 1;
                }
            }
        }
    }

    public void insert(long value) {
        int j;
        for (j = 0; j <= nItems-1; j++) {
            if (a[j] > value)
                break;
        }
        for (int k = nItems; k > j; k--) {
            a[k] = a[k - 1];
        }
        a[j] = value;
        nItems++;
    }


    public boolean delete(long value) {
        int j = find(value);
        if (j == nItems) {
            return false;
        } else {
            for (int k = 0; k < nItems; k++) {
                a[k] = a[k + 1];
            }
            nItems--;
            return true;
        }
    }

    protected void display() {
        for (int i = 0; i < nItems; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

}


public class BinarySerach {
    public static void main(String[] args) {
        int maxSize = 100;
        OrdArray arr;
        arr = new OrdArray(maxSize);
        arr.insert(23);
        arr.insert(26);
        arr.insert(29);
        arr.insert(30);
        arr.insert(39);
        int searchKey = 30;
        if (arr.find(searchKey) != arr.size()) {
            System.out.println("found: " + searchKey);
        } else {
            System.out.println("Can't found " + searchKey);
        }

        arr.display();
        arr.delete(23);
        arr.delete(39);
        arr.display();
    }
}
