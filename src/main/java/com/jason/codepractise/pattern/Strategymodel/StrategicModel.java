package com.jason.codepractise.pattern.Strategymodel;

/**
 * author: zhangkai
 * date: 2019-08-25
 * description: 策略模式
 * 策略模式将一组完成相同工作的不同方式的代码分别放到不同的类中，
 * 并通过策略模式实现在运行中的相互切换。
 */
public class StrategicModel {
    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        int a = context.executeStrategy(1,2);
        System.out.println(a);
        context = new Context(new OperationMultiply());
        System.out.println(context.executeStrategy(3, 4));
    }
}

interface Strategy {
    int doOperation(int num1, int num2);
}

class OperationAdd implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}

class OperationSubstract implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}

class OperationMultiply implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}

/**
 * 上下文
 */
class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }
}




