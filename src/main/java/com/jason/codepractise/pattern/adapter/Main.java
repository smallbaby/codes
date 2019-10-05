package com.jason.codepractise.pattern.adapter;

/**
 * author: zhangkai
 * date: 2019-10-05
 * description:
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("类适配器模式测试..");
        Target target = new ClassAdapter();
        target.request();
        System.out.println("-------------");
        System.out.println("对象适配器模式测试..");
        Adaptee adaptee = new Adaptee();
        Target target1 = new ObjectAdapter(adaptee);
        target1.request();
    }
}

interface Target {
    void request();
}

//适配者接口
class Adaptee {
    public void specificRequest() {
        System.out.println("适配者中的业务代码被调用");
    }
}

class ObjectAdapter implements Target {
    private Adaptee adaptee;
    public ObjectAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }
    @Override
    public void request() {
        adaptee.specificRequest();
    }
}


class ClassAdapter extends Adaptee implements Target {

    @Override
    public void request() {
        specificRequest();
    }
}
