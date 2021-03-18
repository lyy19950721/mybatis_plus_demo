package com.mipo.pattern.test2;

/**
 * @Classname OperationAdd
 * @Description TODO
 * @Date 2021/1/7 10:43
 * @Created by li.yy
 */
public class OperationAdd implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
