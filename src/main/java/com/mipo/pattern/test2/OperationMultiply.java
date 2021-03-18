package com.mipo.pattern.test2;

/**
 * @Classname OperationMultiply
 * @Description TODO
 * @Date 2021/1/7 10:43
 * @Created by li.yy
 */
public class OperationMultiply implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
