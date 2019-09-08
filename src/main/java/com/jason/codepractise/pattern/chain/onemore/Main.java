package com.jason.codepractise.pattern.chain.onemore;

/**
 * author: zhangkai
 * date: 2019-09-07
 * description:
 */
public class Main {
    public static void main(String[] args) {
        String input = "3";
        OneCase oneCase = new OneCase("1".equalsIgnoreCase(input));
        TwoCase twoCase = new TwoCase("2".equalsIgnoreCase(input));
        DefaultCase defaultCase = new DefaultCase(true);
        oneCase.setNextCase(twoCase);
        twoCase.setNextCase(defaultCase);
        oneCase.handle();
    }
}
