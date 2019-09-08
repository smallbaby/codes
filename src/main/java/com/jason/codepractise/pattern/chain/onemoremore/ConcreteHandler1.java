package com.jason.codepractise.pattern.chain.onemoremore;

/**
 * author: zhangkai
 * date: 2019-09-07
 * description:
 */
public class ConcreteHandler1 extends Handler{
    @Override
    public void handleMessage(int type) {
        if (type == 1 || type ==3) {
            System.out.println("ConcreteHandler1 end.");
        } else {
            if (nextHandler != null) {
                nextHandler.handleMessage(type);
            } else {
                System.out.println("没人能处理这个消息.");
            }
        }
    }
}
