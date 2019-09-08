package com.jason.codepractise.pattern.chain.onemore.extend;

import java.util.ArrayList;
import java.util.List;

/**
 * author: zhangkai
 * date: 2019-09-07
 * description:
 */
public class CaseChain implements BaseCase {
    private List<BaseCase> mCaseList = new ArrayList<>();
    private int index = 0;

    public CaseChain addBaseCase(BaseCase baseCase) {
        mCaseList.add(baseCase);
        return this;
    }

    @Override
    public void doSomething(String input, BaseCase baseCase) {
        if (index == mCaseList.size()) return;
        BaseCase currentBase = mCaseList.get(index);
        index ++;
        currentBase.doSomething(input, this);
    }
}
