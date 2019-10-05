package com.jason.codepractise.pattern.proxy;

import java.lang.reflect.Proxy;

/**
 * author: zhangkai
 * date: 2019-09-30
 * description:
 */
public class Main {
    public static void main(String[] args1) {
//        Programmer programer = new ProgramerBig(new JavaA());
//        programer.coding();
//        Programmer programmer1 = new ProgramerBigA();
//        programmer1.coding();

        JavaA javaA = new JavaA();
        Programmer programmerWaterArmy = (Programmer) Proxy.newProxyInstance(javaA.getClass().getClassLoader(), javaA.getClass().getInterfaces(),(proxy,method,args)-> {
            if (method.getName().equals("coding")) {
                method.invoke(javaA, args);
                System.out.println("哈哈哈哈哈哈");
            } else {
                return method.invoke(javaA, args);
            }
            return null;
        });
        programmerWaterArmy.coding();

    }
}

interface Programmer {
    void coding();
}

class JavaA implements Programmer {
    @Override
    public void coding() {
        System.out.println("撸撸撸撸......");
    }
}

class ProgramerBigA implements Programmer {
    private JavaA javaA;
    public ProgramerBigA() {
        this.javaA = new JavaA();
    }
    @Override
    public void coding() {
        javaA.coding();
        postDoSomething();
    }

    public void postDoSomething() {
        System.out.println("不错..");
    }
}


class ProgramerBig implements Programmer {
    private JavaA javaA;
    public ProgramerBig(JavaA javaA) {
        this.javaA = javaA;
    }
    @Override
    public void coding() {
        javaA.coding();
        postDoSomething();
    }

    public void postDoSomething() {
        System.out.println("不错..");
    }
}



