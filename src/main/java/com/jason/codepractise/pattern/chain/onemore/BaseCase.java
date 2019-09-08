package com.jason.codepractise.pattern.chain.onemore;

/**
 * author: zhangkai
 * date: 2019-09-07
 * description:
 */
public abstract class BaseCase {
    private boolean isConusme; //为true，就当前节点处理
    public BaseCase(boolean isConusme) {
        this.isConusme = isConusme;
    }

    private BaseCase nextCase;

    public void setNextCase(BaseCase nextCase) {
        this.nextCase = nextCase;
    }

    public void handle() {
        if (isConusme) {
            doSomething();
        } else {
            if (null != nextCase) {
                nextCase.handle();
            }
        }
    }
    abstract protected void doSomething();
}
