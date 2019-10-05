package com.jason.codepractise.pattern.adapter.motor;

/**
 * author: zhangkai
 * date: 2019-10-05
 * description: 双向适配
 */
public class TwoMain {
    public static void main(String[] args) {
        System.out.println("目标通过双向适配器访问适配者");
        TwoWayAdaptee adaptee  = new AdapteeRealize();
        TwoWayTarget target = new TwoWayApapter(adaptee);
        target.request();
    }
}


interface TwoWayTarget {
    void request();
}

interface TwoWayAdaptee {
    void specificRequest();
}

class TargetRealize implements TwoWayTarget {
    @Override
    public void request() {
        System.out.println("目标代码被调用..");
    }
}

class AdapteeRealize implements TwoWayAdaptee {
    @Override
    public void specificRequest() {
        System.out.println("适配者代码被调用....");
    }
}


class TwoWayApapter implements TwoWayAdaptee, TwoWayTarget {

    private TwoWayTarget target;
    private TwoWayAdaptee adaptee;

    public TwoWayApapter(TwoWayTarget target) {
        this.target = target;
    }

    public TwoWayApapter(TwoWayAdaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest();
    }

    @Override
    public void specificRequest() {
        target.request();
    }
}





