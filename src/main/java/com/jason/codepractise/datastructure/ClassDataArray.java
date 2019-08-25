package com.jason.codepractise.datastructure;

/**
 * author: zhangkai
 * date: 2019-08-26
 * description:
 */
public class ClassDataArray {
    private Person[] a;
    private int nElems;

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
}


class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
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
}