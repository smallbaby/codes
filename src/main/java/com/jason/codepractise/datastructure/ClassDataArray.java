package com.jason.codepractise.datastructure;

/**
 * author: zhangkai
 * date: 2019-08-26
 * description:
 */
public class ClassDataArray {
    private Person[] a;
    private int nElems;


    public static void main(String[] args) {
        int maxSize = 100;
        ClassDataArray cda;
        cda = new ClassDataArray(maxSize);

        cda.insert("k0", "z", 19);
        cda.insert("k1", "z1", 29);
        cda.insert("k2", "z1", 69);
        cda.insert("k3", "z3", 49);
        cda.insert("k4", "z2", 89);
        cda.displayA();
        String serachKey = "k2";
        Person peron = cda.find(serachKey);
        System.out.println(peron);
        cda.delete("k1");
        cda.displayA();

    }

    public ClassDataArray(int max) {
        a = new Person[max];
        nElems = 0;
    }

    public Person find(String searchKey) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (a[j].getLastName().equals(searchKey)) {
                break;
            }
        }
        if (j == nElems) {
            return null;
        } else {
            return a[j];
        }
    }

    public void insert(String last, String first, int age) {
        a[nElems] = new Person(last, first, age);
        nElems++;
    }

    public boolean delete(String serachName) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (a[j].getLastName().equalsIgnoreCase(serachName)) {
                break;
            }
        }
        if (j == nElems) {
            return false;
        } else {
            for (int k = j; k < nElems; k++) {
                a[k] = a[k + 1]; // 后边的元素往前移
            }
            nElems--;
            return true;
        }
    }

    public void displayA() {
        for (int j = 0; j < nElems; j++) {
            a[j].displayA();
        }
    }
}


class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String lastName, String firstName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void displayA() {
        System.out.print("first:" + this.firstName);
        System.out.print("\tlast:" + this.lastName);
        System.out.print("\tage:" + this.age);
        System.out.println();
    }
}