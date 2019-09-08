package com.jason.codepractise.pattern.chain.onemore.extend;

/**
 * author: zhangkai
 * date: 2019-09-07
 * description:
 */
public class Demo {
    public static void main(String[] args) {
        String input = "1";
        CaseChain caseChain = new CaseChain();
        caseChain.addBaseCase(new OneCase()).addBaseCase(new TwoCase());
        caseChain.doSomething(input, caseChain);
    }
}
