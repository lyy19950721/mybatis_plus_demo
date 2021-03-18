package com.mipo.pattern.test5;

/**
 * @Classname Demo
 * @Description TODO
 * @Date 2021/1/8 10:54
 * @Created by li.yy
 */
public class Demo {

    /**
     * 责任链模式
     * @param args
     */
    public static void main(String[] args) {
        FactoryHandler.getFirstGatewayHandler().service();
    }
}
