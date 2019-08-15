package com.jason.codepractise.thread.p_r_test;


class ValueObject {
    public static String value = "";
}


public class Run {
    public static void main(String[] args) {
        String lock = new String("");
        P p = new P(lock);
        C c = new C(lock);

        ThreadP pt = new ThreadP(p);
        ThreadC pc = new ThreadC(c);
        pt.start();
        pc.start();
    }

}
