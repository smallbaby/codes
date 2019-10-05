package com.jason.codepractise.pattern.singleton;

import com.jason.codepractise.thread.p_r_test.P;
import org.springframework.context.annotation.Lazy;
import sun.jvm.hotspot.debugger.cdbg.basic.LazyBlockSym;

/**
 * author: zhangkai
 * date: 2019-09-29
 * description:
 */
public class Demo {
    public static void main(String[] args) {
        President president = President.getInstance();
        president.getName();
        President president1 = President.getInstance();
        president1.getName();
        if (president == president1) {
            System.out.println("他们是同一个人");
        } else {
            System.out.println("他们不是同一个人.");
        }
    }
}

/**
 * 懒汉式单例，只有当第一次调用时，才创建这个单例
 */
class LazySingleton {
    private static volatile LazySingleton instance = null;
    private LazySingleton() {}
    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}

/**
 * 饿汉式单例，一旦加载就创建，等待获取使用
 * 线程安全
 */
class HungrySingleton {
    private static final HungrySingleton instance = new HungrySingleton();
    private HungrySingleton() {}

    public static HungrySingleton getInstance() {
        return instance;
    }

}

class President {
    private static volatile President instance = null; // 保证instance在所有线程中同步
    private President() {
        System.out.println("产生一个总统.");
    }
    public static synchronized President getInstance() {
        if(instance == null) {
            instance = new President();
        } else {
            System.out.println("已经有一个总统了，不能产生新总统.");
        }
        return instance;
    }
    public void getName() {
        System.out.println("我是总统.Trunp.");
    }
}







