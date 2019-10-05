package com.jason.codepractise.pattern.proxy;

/**
 * author: zhangkai
 * date: 2019-09-30
 * description:
 */
public class SpecialtyProxy {
    public static void main(String[] args) {
        Specialty specialty = new SgProxy();
        specialty.display();
    }
}


interface Specialty {
    void display();
}

class WySpecialty implements Specialty {
    @Override
    public void display() {
        System.out.println("WySpecialty display..");
    }
}

class SgProxy implements Specialty {
    private WySpecialty realSubject = new WySpecialty();

    @Override
    public void display() {
        realSubject.display();
    }
}