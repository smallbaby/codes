package com.jason.codepractise.pattern.chain.onemoremore;

/**
 * author: zhangkai
 * date: 2019-09-07
 * description:
 */
public class Demo {
    public static void main(String[] args) {
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        Handler handler3 = new ConcreteHandler3();
        handler2.setNextHandler(handler3);
        handler1.setNextHandler(handler2);
        handler1.handleMessage(1);
        handler1.handleMessage(2);
        handler1.handleMessage(4);
        handler1.handleMessage(7);
    }
}
