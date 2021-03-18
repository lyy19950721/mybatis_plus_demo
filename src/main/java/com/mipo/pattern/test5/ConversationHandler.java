package com.mipo.pattern.test5;

/**
 * @Classname ConversationHandler
 * @Description TODO
 * @Date 2021/1/8 10:52
 * @Created by li.yy
 */
public class ConversationHandler extends GatewayHandler {
    @Override
    protected void service() {
        System.out.println("three");
        nextService();
    }
}
