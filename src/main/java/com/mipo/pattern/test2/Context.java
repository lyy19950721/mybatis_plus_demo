package com.mipo.pattern.test2;

/**
 * @Classname Context
 * @Description TODO
 * @Date 2021/1/7 10:44
 * @Created by li.yy
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2){
        return strategy.doOperation(num1, num2);
    }
}
