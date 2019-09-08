package com.jason.codepractise.pattern.chain.onemore.extend;

/**
 * author: zhangkai
 * date: 2019-09-07
 * description:
 */
public class OneCase implements BaseCase {
    @Override
    public void doSomething(String input, BaseCase baseCase) {
        if("1".equals(input)) {
            System.out.println(getClass().getName());
            return;
        }
        baseCase.doSomething(input, baseCase);
    }
}
