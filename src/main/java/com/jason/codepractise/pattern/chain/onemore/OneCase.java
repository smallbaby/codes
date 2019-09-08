package com.jason.codepractise.pattern.chain.onemore;

/**
 * author: zhangkai
 * date: 2019-09-07
 * description:
 */
public class OneCase extends BaseCase {

    public OneCase(boolean isConsume) {
        super(isConsume);
    }

    @Override
    protected void doSomething() {
        System.out.println(getClass().getName());
    }
}