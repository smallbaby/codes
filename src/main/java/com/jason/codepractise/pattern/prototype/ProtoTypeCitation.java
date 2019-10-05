package com.jason.codepractise.pattern.prototype;

/**
 * author: zhangkai
 * date: 2019-09-29
 * description:
 */
public class ProtoTypeCitation {
    public static void main(String[] args) throws CloneNotSupportedException {
        Citaion obj1 = new Citaion("张三", "同学：三好学生", "清华大学");
        obj1.display();
        Citaion obj2 = (Citaion) obj1.clone();
        obj2.setName("李四");
        obj2.display();
    }
}

class Citaion implements Cloneable {
    String name;
    String info;
    String college;

    Citaion(String name, String info, String college) {
        this.name = name;
        this.info = info;
        this.college = college;
        System.out.println("奖状创建成功.");
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    void display() {
        System.out.println(name + info + college);
    }

    public Object clone() throws CloneNotSupportedException {
        System.out.println("奖状copy成功.");
        return (Citaion) super.clone();
    }
}
