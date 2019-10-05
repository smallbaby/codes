package com.jason.codepractise.pattern.proxy;

/**
 * author: zhangkai
 * date: 2019-09-30
 * description:
 */
public class ProxyTest {
    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.request();
    }
}

interface Subject {
    void request();
}

class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("访问真实主题方法...");
    }
}

class Proxy implements Subject {
    private RealSubject realSubject;

    @Override
    public void request() {
        if (realSubject == null) {
            realSubject = new RealSubject();
        }
        preRequest();
        realSubject.request();
        postRequest();

    }

    public void preRequest() {
        System.out.println("预处理.");
    }

    public void postRequest() {
        System.out.println("后处理.");
    }

}
