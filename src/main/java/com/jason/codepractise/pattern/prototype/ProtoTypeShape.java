package com.jason.codepractise.pattern.prototype;

import sun.security.provider.SHA;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * author: zhangkai
 * date: 2019-09-29
 * description:
 */
public class ProtoTypeShape {
    public static void main(String[] args) {
        ProtoTypeManager pm = new ProtoTypeManager();
        Shape obj1 = (Circle) pm.getShape("Circle");
        obj1.countArea();
        Shape obj2 = (Square) pm.getShape("Square");
        obj2.countArea();
    }
}

interface Shape extends Cloneable {
    public Object clone();
    public void countArea();
}

class Circle implements Shape {
    @Override
    public Object clone() {
        Circle circle = null;
        try {
            circle = (Circle)super.clone();
        }catch (CloneNotSupportedException e) {
            System.out.println("拷贝圆失败!");
        }
        return circle;
    }

    @Override
    public void countArea() {
        int r = 0;
        System.out.println("这是一个圆，请输入圆的半径：");
        Scanner input = new Scanner(System.in);
        r = input.nextInt();
        System.out.println("该圆的面积=" + 3.1415 * r * r + "\n");
    }
}

class Square implements Shape {
    @Override
    public Object clone() {
        Square square = null;
        try {
            square = (Square)super.clone();
        }catch (CloneNotSupportedException e) {
            System.out.println("拷贝正方形失败!");
        }
        return square;
    }

    @Override
    public void countArea() {
        int r = 0;
        System.out.println("这是一个正方形，请输入边长：");
        Scanner input = new Scanner(System.in);
        r = input.nextInt();
        System.out.println("该正方形的面积=" + r * r + "\n");
    }
}

class ProtoTypeManager {
    private Map<String, Shape> ht = new HashMap<>();
    public ProtoTypeManager() {
        ht.put("Circle", new Circle());
        ht.put("Square", new Square());
    }
    public void addShape(String key, Shape obj) {
        ht.put(key, obj);
    }
    public Shape getShape(String key) {
        Shape temp = ht.get(key);
        return (Shape) temp.clone();
    }
}

