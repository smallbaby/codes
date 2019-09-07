package com.jason.codepractise.pattern.chain;

/**
 * author: zhangkai
 * date: 2019-09-07
 * description:
 */
public class FileLogger extends AbstractLogger {
    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}
