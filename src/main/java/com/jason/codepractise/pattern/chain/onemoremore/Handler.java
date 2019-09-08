package com.jason.codepractise.pattern.chain.onemoremore;

/**
 * author: zhangkai
 * date: 2019-09-07
 * description:
 */
public abstract class Handler {
    protected Handler nextHandler; // 下一个链节点.

    public Handler getNextHandler() {
        return nextHandler;
    }
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handleMessage(int type);
}
