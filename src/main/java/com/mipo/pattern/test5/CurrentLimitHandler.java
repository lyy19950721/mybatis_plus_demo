package com.mipo.pattern.test5;

/**
 * @Classname CurrentLimitHandler
 * @Description TODO
 * @Date 2021/1/8 10:47
 * @Created by li.yy
 */
public class CurrentLimitHandler extends GatewayHandler {
    @Override
    protected void service() {
        System.out.println("one >>>");
        nextService();
    }
}
