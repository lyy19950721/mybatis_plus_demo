package com.mipo.pattern.test5;

/**
 * @Classname BlackListHandler
 * @Description TODO
 * @Date 2021/1/8 10:48
 * @Created by li.yy
 */
public class BlackListHandler extends GatewayHandler {
    @Override
    protected void service() {
        System.out.println("two>>>");
        nextService();
    }
}
