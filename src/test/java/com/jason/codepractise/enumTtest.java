package com.jason.codepractise;


import org.junit.Test;

import java.io.Serializable;


enum Day {
    SUNDAY, MONDAY,TUESDAY,WEDESDAY,THURSDAY, FRIDAY,SATUDAY
}

enum ComponentTypeEnum implements Serializable {
    LineChart(1, "hello", "line");
    private Integer code;
    private String description;
    private String type;


    ComponentTypeEnum(Integer code, String description, String type) {
        this.code = code;
        this.description = description;
        this.type = type;
    }
}

public class enumTtest {
    Day day;
    @Test
    public void dayTest() {
        day = Day.FRIDAY;
        switch (day) {
            case MONDAY:
                System.out.println("hello");
                break;
            case THURSDAY:
                System.out.println("xxxx");
                break;
            default:
                    System.out.println("default");
        }
    }

    @Test
    public void linechartEnum() {
    }
}
