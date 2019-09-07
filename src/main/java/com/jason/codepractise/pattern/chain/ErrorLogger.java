package com.jason.codepractise.pattern.chain;

/**
 * author: zhangkai
 * date: 2019-09-07
 * description:
 */
public class ErrorLogger extends AbstractLogger{
    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}
