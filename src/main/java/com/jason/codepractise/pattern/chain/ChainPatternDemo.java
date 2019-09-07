package com.jason.codepractise.pattern.chain;

/**
 * author: zhangkai
 * date: 2019-09-07
 * description:
 */
public class ChainPatternDemo {
    private static AbstractLogger getChainOfLoggers() {
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);
        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);
        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLoggers();
        loggerChain.logMessage(AbstractLogger.INFO, "This is an infomation.");
        loggerChain.logMessage(AbstractLogger.DEBUG, "This is an debug.");
        loggerChain.logMessage(AbstractLogger.ERROR, "This is an error.");

    }
}
